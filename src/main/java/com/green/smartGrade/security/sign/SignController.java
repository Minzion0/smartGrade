package com.green.smartGrade.security.sign;


import com.green.smartGrade.security.CommonRes;
import com.green.smartGrade.security.sign.model.SignInParam;
import com.green.smartGrade.security.sign.model.SignInResultDto;
import com.green.smartGrade.security.sign.model.SignUpResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@Tag(name = "로그인")
@RequestMapping("/api")
public class SignController {
    private final SignService SERVICE;

    //ApiParam은 문서 자동화를 위한 Swagger에서 쓰이는 어노테이션이고
    //RequestParam은 http 로부터 요청 온 정보를 받아오기 위한 스프링 어노테이션이다.


//    @PostMapping("/sign-in")   로그인 하자마자 토큰
//    @Operation(summary = "로그인")
//    public SignInResultDto signIn(HttpServletRequest req, @RequestParam String id, @RequestParam String password, @RequestParam String role) throws Exception {
//
//        String ip = req.getRemoteAddr();
//        log.info("[signIn] 로그인을 시도하고 있습니다. id: {}, pw: {}, role: {}, ip: {}", id, password, role, ip);
//
//        SignInResultDto dto = SERVICE.signIn(id, password, ip, role);
//        if(dto.getCode() == CommonRes.SUCCESS.getCode()) {
//            log.info("[signIn] 정상적으로 로그인 되었습니다. id: {}, token: {}", id, dto.getAccessToken());
//        }
//        return dto;
//    }
    @PostMapping("/sign-in")
    @Operation(summary = "로그인")
    public SignInResultDto signIn(HttpServletRequest req, @RequestBody SignInParam param) throws Exception {
//@RequestParam String id, @RequestParam String password, @RequestParam String role
        String ip = req.getRemoteAddr();
        log.info("[signIn] 로그인을 시도하고 있습니다. id: {}, pw: {}, role: {}, ip: {}", param.getId(), param.getPassword(), param.getRole(), ip);

        SignInResultDto dto = SERVICE.signIn(param, ip);

//
//        if(dto.getCode() == CommonRes.SUCCESS.getCode()) {
//            log.info("[signIn] 정상적으로 로그인 되었습니다. id: {}, token: {}", id, dto.getAccessToken());
//        }

        return dto;

    }

//    @PostMapping("/sign-up")
//    public SignUpResultDto signUp(@RequestParam String id
//                                , @RequestParam String pw
//                                , @RequestParam String nm
//                                , @RequestParam String role) {
//        log.info("[signUp] 회원가입을 수행합니다. id: {}, pw: {}, nm: {}, role: {}", id, pw, nm, role);
//        SignUpResultDto dto = SERVICE.signUp(id, pw, nm, role);
//        log.info("[signUp] 회원가입 완료 id: {}", id);
//        return dto;
//    }

    @GetMapping("/refresh-token")
    @Operation(summary = "토큰발행")
    public ResponseEntity<SignUpResultDto> refreshToken(HttpServletRequest req,
                                                        @RequestParam String refreshToken) {

        SignUpResultDto dto = SERVICE.refreshToken(req, refreshToken);
        return dto == null ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null) : ResponseEntity.ok(dto);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout (HttpServletRequest req) {
        SERVICE.logout(req);
        ResponseCookie responseCookie = ResponseCookie.from("refresh-token", "")
                .maxAge(0)
                .path("/")
                .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .build();
    }
    @GetMapping("/otp")
    @Operation(summary = "otp 등록 어플에 등록",description = "role : ROLE_ 기본 관리자 : ADMIN ,학생 : STUDENT , 교수 : PROFESSOR" +
            "<br>iuser : 여기엔 관리자인 경우 pk 교수 및 학생은 학번" +
            "<br>\"barcodeUrl : qr코트 주소")
    public ResponseEntity<?> otp(String iuser,String role) {

        return SERVICE.otp(iuser,role);
    }
    @GetMapping("/otp-valid")
    @Operation(summary = "otp 인증" ,description = "otpNum : otp번호" +
            "role : ROLE_ 기본 관리자 : ADMIN ,학생 : STUDENT , 교수 : PROFESSOR" +
            "<br>iuser : 여기엔 관리자인 경우 pk 교수 및 학생은 학번")
    public SignInResultDto otpValid(HttpServletRequest req,@RequestParam String otpNum,String iuser,String role) {
       return   SERVICE.otpValid(req,otpNum, iuser,role);
    }
}