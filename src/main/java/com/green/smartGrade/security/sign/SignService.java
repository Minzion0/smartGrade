package com.green.smartGrade.security.sign;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.smartGrade.security.CommonRes;
import com.green.smartGrade.security.config.RedisService;
import com.green.smartGrade.security.config.security.JwtTokenProvider;
import com.green.smartGrade.security.config.security.UserDetailsMapper;
import com.green.smartGrade.security.config.security.model.*;
import com.green.smartGrade.security.config.security.AuthenticationFacade;
import com.green.smartGrade.security.config.security.otp.OtpRes;
import com.green.smartGrade.security.config.security.otp.TOTP;
import com.green.smartGrade.security.config.security.otp.TOTPTokenGenerator;
import com.green.smartGrade.security.sign.model.SignInParam;
import com.green.smartGrade.security.sign.model.SignInResultDto;
import com.green.smartGrade.security.sign.model.SignUpResultDto;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignService {
    private final UserDetailsMapper MAPPER;
    private final JwtTokenProvider JWT_PROVIDER;
    private final PasswordEncoder PW_ENCODER;
    private final RedisService REDIS_SERVICE;
    private final AuthenticationFacade FACADE;
    private final ObjectMapper OBJECT_MAPPER;
    private final TOTPTokenGenerator totp;



    public SignInResultDto signIn(SignInParam param, String ip) throws Exception {
        SignInResultDto dto = SignInResultDto.builder().build();
        log.info("[getSignInResult] signDataHandler로 회원 정보 요청");
        String id = param.getId();
        String password = param.getPassword();
        String role = param.getRole();
        UserEntity user = MAPPER.getByUid(id, role); // null 처리를 지금은 안 한상태

        log.info("[getSignInResult] id: {}", id);
        log.info("[getSignInResult] 패스워드 비교");
        if (!PW_ENCODER.matches(password, user.getUpw())) {
            log.info("비밀번호 다름");
            //throw new RuntimeException("비밀번호 다름");
            setFileResult(dto);
           return dto;
        }
        log.info("[getSignInResult] 패스워드 일치");
////        /// -- opt
////        // RT가 이미 있을 경우
//        if (user.getSecretKey()==null){
//            //토큰 발행 메소드
//            return issueToken(ip, role, user);
//        }else {
//            //otp 확인 메소드
//
//             return null;
//        }
        setSuccessResult(dto);
        dto=issueToken(ip, user.getUid(),role);
        if (role.equals("ROLE_ADMIN")||user.getSecretKey()==null ){
            dto.setSecretKey(false);

        }

       return dto;

    }



    public SignInResultDto refreshToken(HttpServletRequest req, String refreshToken) throws RuntimeException {
        if (!(JWT_PROVIDER.isValidateToken(refreshToken, JWT_PROVIDER.REFRESH_KEY))) {
            return null;
        }

        String ip = req.getRemoteAddr();
        String accessToken = JWT_PROVIDER.resolveToken(req, JWT_PROVIDER.TOKEN_TYPE);
        Claims claims = JWT_PROVIDER.getClaims(refreshToken, JWT_PROVIDER.REFRESH_KEY);
        if (claims == null) {
            return null;
        }
        String strIuser = claims.getSubject();
        Long iuser = Long.valueOf(strIuser);

        String redisKey = String.format("b:RT(%s):%s:%s", "Server", iuser, ip);
        String value = REDIS_SERVICE.getValues(redisKey);
        if (value == null) { // Redis에 저장되어 있는 RT가 없을 경우
            return null; // -> 재로그인 요청
        }

        try {
            RedisJwtVo redisJwtVo = OBJECT_MAPPER.readValue(value, RedisJwtVo.class);
            if (!redisJwtVo.getAccessToken().equals(accessToken)
                    || !redisJwtVo.getRefreshToken().equals(refreshToken)) {
                return null;
            }

            List<String> roles = (List<String>) claims.get("roles");
            String reAccessToken = JWT_PROVIDER.generateJwtToken(strIuser, roles, JWT_PROVIDER.ACCESS_TOKEN_VALID_MS, JWT_PROVIDER.ACCESS_KEY);

            //redis 업데이트
            RedisJwtVo updateRedisJwtVo = RedisJwtVo.builder()
                    .accessToken(reAccessToken)
                    .refreshToken(redisJwtVo
                            .getRefreshToken())
                    .build();
            String upateValue = OBJECT_MAPPER.writeValueAsString(updateRedisJwtVo);
            REDIS_SERVICE.setValues(redisKey, upateValue);
            Long expiration = JWT_PROVIDER.REFRESH_TOKEN_VALID_MS;
            REDIS_SERVICE.setValuesWithTimeout(accessToken, "login", expiration);

            SignInResultDto result = SignInResultDto.builder()
                    .accessToken(reAccessToken)
                    .refreshToken(refreshToken)
                    .build();

            setSuccessResult(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setSuccessResult(SignUpResultDto result) {
        result.setSuccess(true);
        result.setSecretKey(true);
        result.setCode(CommonRes.SUCCESS.getCode());
        result.setMsg(CommonRes.SUCCESS.getMsg());
    }

    private void setFileResult(SignUpResultDto result) {
        result.setSuccess(false);
        result.setCode(CommonRes.FAIL.getCode());
        result.setMsg(CommonRes.FAIL.getMsg());
    }

    public void logout(HttpServletRequest req) {

        String accessToken = JWT_PROVIDER.resolveToken(req, JWT_PROVIDER.TOKEN_TYPE);
        Long iuser = FACADE.getLoginUserPk();
        String ip = req.getRemoteAddr();

        // Redis에 저장되어 있는 RT 삭제
        String redisKey = String.format("b:RT(%s):%s:%s", "Server", iuser, ip);
        String refreshTokenInRedis = REDIS_SERVICE.getValues(redisKey);
        if (refreshTokenInRedis != null) {
            REDIS_SERVICE.deleteValues(redisKey);
        }

        // Redis에 로그아웃 처리한 AT 저장
        long expiration = JWT_PROVIDER.getTokenExpirationTime(accessToken, JWT_PROVIDER.ACCESS_KEY) - LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        REDIS_SERVICE.setValuesWithTimeout(accessToken, "logout", expiration);  //남은시간 이후가 되면 삭제가 되도록 함.
    }

    public ResponseEntity<?> otp(String uid, String role) {
        System.out.println("uid = " + uid);
        System.out.println("role = " + role);

//        String s = JWT_PROVIDER.resolveToken(haber, JWT_PROVIDER.TOKEN_TYPE);
//        log.info("sssssssssss : {}",s);
//        Object details = JWT_PROVIDER.getAuthentication(s);
//        System.out.println("authentication = " + details);


        String secretKey = totp.generateSecretKey();//설정할 secretKey를 생성
        UserSelRoleEmailVo vo = MAPPER.getUserRoleEmail(uid, role);

        String issuer = "GreenUniversity";
        String account = vo.getEmail();
        String barcodeUrl = totp.getGoogleAuthenticatorBarcode(secretKey, account, issuer);
        OtpRes res = OtpRes.builder().barcodeUrl(barcodeUrl).secretKey(secretKey).build();

        try {
            updSecretKey(uid, role, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK).body(res);

    }


    public int updSecretKey(String uid, String role, String secretKey) throws Exception {
        UserUpdSecretKeyDto dto = new UserUpdSecretKeyDto();
        dto.setRole(role);
        dto.setSecretKey(secretKey);
        dto.setUid(uid);
        int result = MAPPER.updSecretKey(dto);
        if (result == 0) {
            throw new Exception();
        }

        return result;
    }

    public SignInResultDto otpValid(HttpServletRequest req,String inputCode, String uid, String role) {

        UserSelRoleEmailVo vo = MAPPER.getUserRoleEmail(uid, role);
        String otpCode = getOtpCode(vo.getSecretKey());

        boolean result = otpCode.equals(inputCode);
        if (result){
            String ip = req.getRemoteAddr();
            try {

                return issueToken(ip,uid,role);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    private String getOtpCode(String secretKey) {

        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);

        return TOTP.getOTP(hexKey);
    }
    private SignInResultDto issueToken(String ip, String iuser,String role) throws JsonProcessingException {

        System.out.println("iuser = " + iuser);
        UserEntity user = MAPPER.getByUid(iuser, role);
        if ("ROLE_STUDENT".equals(role)){
            user = MAPPER.getUserSecret(iuser, role);

        }


        System.out.println("user = " + user);
        String  redisKey = String.format("b:RT(%s):%s:%s", "Server", user.getIuser(), ip);
        if (REDIS_SERVICE.getValues(redisKey) != null) {
            REDIS_SERVICE.deleteValues(redisKey);
        }

        log.info("[getSignInResult] access_token 객체 생성");
        String accessToken = JWT_PROVIDER.generateJwtToken(String.valueOf(user.getIuser()), Collections.singletonList(user.getRole()), JWT_PROVIDER.ACCESS_TOKEN_VALID_MS, JWT_PROVIDER.ACCESS_KEY);
        String refreshToken = JWT_PROVIDER.generateJwtToken(String.valueOf(user.getIuser()), Collections.singletonList(user.getRole()), JWT_PROVIDER.REFRESH_TOKEN_VALID_MS, JWT_PROVIDER.REFRESH_KEY);

        //Redis에 RT 저장
        RedisJwtVo redisJwtVo = RedisJwtVo.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

        String value = OBJECT_MAPPER.writeValueAsString(redisJwtVo);
        REDIS_SERVICE.setValues(redisKey, value);

        // 저장할 목록만 저장하기
        UserTokenEntity tokenEntity = UserTokenEntity.builder()
                .iuser(user.getIuser())
                .role(role)
                .ip(ip)
                .build();

        int result = MAPPER.updUserToken(tokenEntity);

        log.info("[getSignInResult] SignInResultDto 객체 생성");
        SignInResultDto dto = SignInResultDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

        log.info("[getSignInResult] SignInResultDto 객체 값 주입");
        setSuccessResult(dto);
        return dto;
    }



}

