//package com.green.smartGrade.admin.lectureroom;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.green.smartGrade.admin.lectureroom.model.LectureRoomInsDto;
//import com.green.smartGrade.admin.lectureroom.model.LectureRoomInsParam;
//import com.green.smartGrade.admin.lectureroom.model.LectureRoomRes;
//import com.green.smartGrade.security.config.security.model.MyUserDetails;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockPart;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(AdminLectureRoomController.class)
//class AdminLectureRoomControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private AdminLectureRoomService service;
//
//    @BeforeEach
//    void beforeEach() {
//        UserDetails user = createUserDetails();
//
//        SecurityContext context = SecurityContextHolder.getContext();
//        context.setAuthentication(new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities()));
//
//    }
//    private UserDetails createUserDetails() {
//        List<String> roles = new ArrayList<>();
//        roles.add("ROLE_ADMIN");
//        //roles.add("ROLE_ADMIN");
//
//        UserDetails userDetails = MyUserDetails.builder()
//                .iuser(1L)
//                .roles(roles)
//                .build();
//        return userDetails;
//    }
//
//    @Test
//    void insLectureRoom() throws Exception{
//    }
//
//    @Test
//    void getLectureRoom() {
//    }
//
//    @Test
//    void delLectureRoom() {
//    }
//}