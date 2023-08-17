package com.green.smartGrade.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Controller
public class WebController implements WebMvcConfigurer {
//    @GetMapping({"/", "/error"})
//    public String index() {
//        log.info("------------------------asdf----------------------");
//        return "index.html";
//    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("{spring:\\w+}").setViewName("forward:/");
//        registry.addViewController("/**{spring:\\w+}").setViewName("forward:/");
//        registry.addViewController("/{spring:\\w+}/**{spring:?!(\\.js|\\.css)$}").setViewName("forward:/");
//    }
}
