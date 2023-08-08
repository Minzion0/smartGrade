package com.green.smartGrade.security.sign;


import com.green.smartGrade.security.CommonRes;
import com.green.smartGrade.security.config.security.model.MyUserDetails;
import com.green.smartGrade.security.sign.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return dto == null ? ResponseEntity.status(405).body(null) : ResponseEntity.ok(dto);
    }

    @PostMapping("/logout")
    @Operation(summary = "로그아웃")
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
            "<br>\"barcodeUrl : qr코드 주소")
    public ResponseEntity<?> otp(@AuthenticationPrincipal MyUserDetails details) {

        Long iuser = details.getIuser();
        String result = String.valueOf(iuser);

        String role = details.getRoles().get(0);

        return SERVICE.otp(result,role);
    }

    @GetMapping("/otp-valid")
    @Operation(summary = "otp 인증" ,description = "otpNum : otp번호" +
            "role : ROLE_ 기본 관리자 : ADMIN ,학생 : STUDENT , 교수 : PROFESSOR" +
            "<br>iuser : 여기엔 관리자인 경우 pk 교수 및 학생은 학번")
    public ResponseEntity<?> otpValid(@AuthenticationPrincipal MyUserDetails details,HttpServletRequest req,@RequestParam String otpNum) {
        Long iuser = details.getIuser();
        String result = String.valueOf(iuser);
        System.out.println("result = " + result);
        String role = details.getRoles().get(0);
        System.out.println("role = " + role);
        boolean otpe = SERVICE.otpValid(req, otpNum, result, role);


       return otpe ? ResponseEntity.ok().body(otpe) : ResponseEntity.status(400).body(otpe);
    }

    @PutMapping("/forgetPassword")
    @Operation(summary = "비밀번호 찾기(변경) 아이디와 OTP 확인")
    public boolean updForgetPassword (String uid, String role, String inputCode) {
        return SERVICE.updForgetPassword(uid, role, inputCode);
    }
    @PutMapping("/changPassword")
    @Operation(summary = "비밀번호 변경")
    public String updPasswordNew(@RequestBody SignSelPasswordTrueDto dto) {
        return SERVICE.updPasswordNew(dto);
    }
}
