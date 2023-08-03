package com.green.smartGrade.security.sign;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.smartGrade.security.CommonRes;
import com.green.smartGrade.security.config.RedisService;
import com.green.smartGrade.security.config.security.JwtTokenProvider;
import com.green.smartGrade.security.config.security.UserDetailsMapper;
import com.green.smartGrade.security.config.security.model.AuthenticationFacade;
import com.green.smartGrade.security.config.security.model.RedisJwtVo;
import com.green.smartGrade.security.config.security.model.UserEntity;
import com.green.smartGrade.security.config.security.model.UserTokenEntity;
import com.green.smartGrade.security.sign.model.SignInResultDto;
import com.green.smartGrade.security.sign.model.SignUpResultDto;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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


    public SignInResultDto signIn(String id, String password, String ip, String role) throws Exception {
        log.info("[getSignInResult] signDataHandler로 회원 정보 요청");
        UserEntity user = MAPPER.getByUid(id, role); // null 처리를 지금은 안 한상태

        log.info("[getSignInResult] id: {}", id);

        log.info("[getSignInResult] 패스워드 비교");
        if(!PW_ENCODER.matches(password, user.getUpw())) {
            throw new RuntimeException("비밀번호 다름");
        }
        log.info("[getSignInResult] 패스워드 일치");

        // RT가 이미 있을 경우
        String redisKey = String.format("RT(%s):%s:%s", "Server", user.getIuser(), ip);
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

    public SignInResultDto refreshToken(HttpServletRequest req, String refreshToken) throws RuntimeException {
        if(!(JWT_PROVIDER.isValidateToken(refreshToken, JWT_PROVIDER.REFRESH_KEY))) {
            return null;
        }

        String ip = req.getRemoteAddr();
        String accessToken = JWT_PROVIDER.resolveToken(req, JWT_PROVIDER.TOKEN_TYPE);
        Claims claims = JWT_PROVIDER.getClaims(refreshToken, JWT_PROVIDER.REFRESH_KEY);
        if(claims == null) {
            return null;
        }
        String strIuser = claims.getSubject();
        Long iuser = Long.valueOf(strIuser);

        String redisKey = String.format("RT(%s):%s:%s", "Server", iuser, ip);
        String value = REDIS_SERVICE.getValues(redisKey);
        if (value == null) { // Redis에 저장되어 있는 RT가 없을 경우
            return null; // -> 재로그인 요청
        }

        try {
            RedisJwtVo redisJwtVo = OBJECT_MAPPER.readValue(value, RedisJwtVo.class);
            if(!redisJwtVo.getAccessToken().equals(accessToken)
                    || !redisJwtVo.getRefreshToken().equals(refreshToken)) {
                return null;
            }

            List<String> roles = (List<String>)claims.get("roles");
            String reAccessToken = JWT_PROVIDER.generateJwtToken(strIuser, roles, JWT_PROVIDER.ACCESS_TOKEN_VALID_MS, JWT_PROVIDER.ACCESS_KEY);

            //redis 업데이트
            RedisJwtVo updateRedisJwtVo = RedisJwtVo.builder()
                    .accessToken(reAccessToken)
                    .refreshToken(redisJwtVo
                            .getRefreshToken())
                    .build();
            String upateValue = OBJECT_MAPPER.writeValueAsString(updateRedisJwtVo);
            REDIS_SERVICE.setValues(redisKey, upateValue);

            return SignInResultDto.builder()
                    .accessToken(reAccessToken)
                    .refreshToken(refreshToken)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setSuccessResult(SignUpResultDto result) {
        result.setSuccess(true);
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
        String redisKey = String.format("RT(%s):%s:%s", "Server", iuser, ip);
        String refreshTokenInRedis = REDIS_SERVICE.getValues(redisKey);
        if (refreshTokenInRedis != null) {
            REDIS_SERVICE.deleteValues(redisKey);
        }

        // Redis에 로그아웃 처리한 AT 저장
        long expiration = JWT_PROVIDER.getTokenExpirationTime(accessToken, JWT_PROVIDER.ACCESS_KEY) - LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        REDIS_SERVICE.setValuesWithTimeout(accessToken, "logout", expiration);  //남은시간 이후가 되면 삭제가 되도록 함.
    }
}

