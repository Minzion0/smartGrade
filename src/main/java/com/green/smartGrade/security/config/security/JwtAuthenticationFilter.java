package com.green.smartGrade.security.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.smartGrade.security.config.RedisService;
import com.green.smartGrade.security.config.security.model.EntryPointErrorResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j @RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider PROVIDER;
    private final RedisService redisService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String token = PROVIDER.resolveToken(req, PROVIDER.TOKEN_TYPE);
        log.info("JwtAuthenticationFilter - doFilterInternal: 토큰 추출 token: {}", token);

        log.info("JwtAuthenticationFilter - doFilterInternal: 토큰 유효성 체크 시작");
//        if (token!=null){
//            Authentication auth = PROVIDER.getAuthentication(token);
//            SecurityContextHolder.getContext().setAuthentication(auth);
//        }
if (token != null){
    Authentication auth = PROVIDER.getAuthentication(token);
    SecurityContextHolder.getContext().setAuthentication(auth);
}
        if(token != null && PROVIDER.isValidateToken(token, PROVIDER.ACCESS_KEY)) {
            Authentication auth = PROVIDER.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            log.info("JwtAuthenticationFilter - doFilterInternal: 토큰 유효성 체크 완료");
        }
//        if(token != null) {
//
//            if (!PROVIDER.isValidateToken(token, PROVIDER.ACCESS_KEY)){
//                ObjectMapper objectMapper = new ObjectMapper();
//                EntryPointErrorResponse msg = new EntryPointErrorResponse();
//                msg.setMsg("인증이 실패하였습니다.");
//                res.setStatus(401);
//                res.getWriter().write(objectMapper.writeValueAsString(msg));
//
//            }else {
//                String isLogout = redisService.getValues(token);
//                if (ObjectUtils.isEmpty(isLogout)){
//                    Authentication auth = PROVIDER.getAuthentication(token);
//                    SecurityContextHolder.getContext().setAuthentication(auth);
//                    log.info("JwtAuthenticationFilter - doFilterInternal: 토큰 유효성 체크 완료");
//
//                }
//                filterChain.doFilter(req, res);
//
//            }
//        }

        filterChain.doFilter(req, res);
    }
}
