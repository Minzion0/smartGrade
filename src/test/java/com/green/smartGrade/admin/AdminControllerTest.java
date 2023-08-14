package com.green.smartGrade.admin;

import com.green.smartGrade.admin.model.AdminInsSemesterParam;
import com.green.smartGrade.security.config.RedisService;
import com.green.smartGrade.security.config.security.JwtTokenProvider;
import com.green.smartGrade.security.config.security.SecurityConfiguration;
import com.green.smartGrade.security.config.security.model.MyUserDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = AdminController.class)
@Import({SecurityConfiguration.class, JwtTokenProvider.class})
class AdminControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AdminService service;

    @MockBean
    private RedisService redisService;

    @BeforeEach
    void beforeEach() {
        UserDetails user = createUserDetails();

        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities()));

    }
    private UserDetails createUserDetails() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        //roles.add("ROLE_ADMIN");

        UserDetails userDetails = MyUserDetails.builder()
                .iuser(1L)
                .roles(roles)
                .build();
        return userDetails;
    }

    @Test
    void semesterIns() {
        AdminInsSemesterParam param= new AdminInsSemesterParam();
        param.setSemester(2);
        param.setYear("2034");
        param.setSemesterStrDate(LocalDate.now());
        param.setSemesterEndDate(LocalDate.of(2024,12,25));
        String path = "/api/admin";


//        mvc.perform(MockMvcRequestBuilders.post(path+"/semester"))
//                .param("semester","2","year","2034","semesterStrDate",LocalDate.now().toString(),"semesterEndDate",LocalDate.of(2024,12,25).toString())

    }

    @Test
    void getSemester() {
    }

    @Test
    void findProfessors() {
    }

    @Test
    void selLecture() {
    }

    @Test
    void updLecture() {
    }
}