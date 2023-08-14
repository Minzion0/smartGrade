package com.green.smartGrade.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.smartGrade.admin.major.model.MajorInsDto;
import com.green.smartGrade.admin.major.model.MajorRes;
import com.green.smartGrade.admin.model.AdminGetSemesterVo;
import com.green.smartGrade.admin.model.AdminInsSemesterParam;
import com.green.smartGrade.admin.model.AdminInsSemesterRes;
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
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = AdminController.class)
@Import({SecurityConfiguration.class, JwtTokenProvider.class})
class AdminControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AdminService service;

    @MockBean
    private RedisService redisService;
@Autowired
    private ObjectMapper objectMapper;

    private String path = "/api/admin";
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
    void semesterIns() throws Exception {
        AdminInsSemesterParam param= new AdminInsSemesterParam();
        param.setSemester(2);
        param.setYear("2034");
        param.setSemesterStrDate(LocalDate.now());
        param.setSemesterEndDate(LocalDate.of(2024,12,25));
        String requestBody = objectMapper.writeValueAsString(param);

        AdminInsSemesterRes res = new AdminInsSemesterRes();
        res.setSemester(2);
        res.setSemesterStrDate(param.getSemesterStrDate());
        res.setSemesterEndDate(param.getSemesterEndDate());

        when(service.semesterIns(param)).thenReturn(res);


        mvc.perform(MockMvcRequestBuilders.post(path+"/semester")
                                .contentType(MediaType.APPLICATION_JSON)
                                 .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.semester").value(param.getSemester()))
                .andExpect(jsonPath("$.semesterStrDate").value(param.getSemesterStrDate().toString()))
                .andExpect(jsonPath("$.semesterEndDate").value(res.getSemesterEndDate().toString()))
                .andDo(print());

        verify(service).semesterIns(any());

    }

    @Test
    void getSemester() throws Exception {

        List<AdminGetSemesterVo> list =new ArrayList<>();
        AdminGetSemesterVo vo = new AdminGetSemesterVo();
        vo.setIsemester(1L);
        vo.setSemester(1);
        vo.setYear("2024");
        vo.setSemesterStrDate(LocalDate.now());
        vo.setSemesterEndDate(LocalDate.of(2024,12,25));
        list.add(vo);
        AdminGetSemesterVo vo1 = new AdminGetSemesterVo();
        vo1.setIsemester(2L);
        vo1.setSemester(2);
        vo1.setYear("2024");
        vo1.setSemesterStrDate(LocalDate.now());
        vo1.setSemesterEndDate(LocalDate.of(2024,12,25));
        list.add(vo1);
        String result = objectMapper.writeValueAsString(list);
        when(service.getSemester(any())).thenReturn(list);

//        mvc.perform(get(path+"/semester")
//                .param("page","1")
//                .contentType(MediaType.ALL)
//                .content(result))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("$.list[0].isemester").value(1L))
//                .andDo(print());
//
//        verify(service).getSemester(any());
//


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