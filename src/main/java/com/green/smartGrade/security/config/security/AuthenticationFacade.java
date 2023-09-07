package com.green.smartGrade.security.config.security;

import com.green.smartGrade.security.config.security.model.MyUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

// 클라이언트가 요청한 값을
@Component
@Configuration
public class AuthenticationFacade {

    public MyUserDetails getLoginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        return userDetails;
    }

    public Long getLoginUserPk () {
        return getLoginUser().getIuser();
    }
}
