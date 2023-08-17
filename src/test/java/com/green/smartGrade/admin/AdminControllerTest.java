//package com.green.smartGrade.admin;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.green.smartGrade.admin.major.model.MajorInsDto;
//import com.green.smartGrade.admin.major.model.MajorRes;
//import com.green.smartGrade.admin.model.*;
//import com.green.smartGrade.security.config.RedisService;
//import com.green.smartGrade.security.config.security.JwtTokenProvider;
//import com.green.smartGrade.security.config.security.SecurityConfiguration;
//import com.green.smartGrade.security.config.security.model.MyUserDetails;
//import com.green.smartGrade.utils.PagingUtils;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@WebMvcTest(controllers = AdminController.class)
//@Import({SecurityConfiguration.class, JwtTokenProvider.class})
//class AdminControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private AdminService service;
//
//    @MockBean
//    private RedisService redisService;
//@Autowired
//    private ObjectMapper objectMapper;
//
//    private String path = "/api/admin";
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
//    void semesterIns() throws Exception {
//        AdminInsSemesterParam param= new AdminInsSemesterParam();
//        param.setSemester(2);
//        param.setYear("2034");
//        param.setSemesterStrDate(LocalDate.now());
//        param.setSemesterEndDate(LocalDate.of(2024,12,25));
//        String requestBody = objectMapper.writeValueAsString(param);
//
//        AdminInsSemesterRes res = new AdminInsSemesterRes();
//        res.setSemester(2);
//        res.setSemesterStrDate(param.getSemesterStrDate());
//        res.setSemesterEndDate(param.getSemesterEndDate());
//
//        when(service.semesterIns(param)).thenReturn(res);
//
//
//        mvc.perform(MockMvcRequestBuilders.post(path+"/semester")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                 .content(requestBody))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("$.semester").value(param.getSemester()))
//                .andExpect(jsonPath("$.semesterStrDate").value(param.getSemesterStrDate().toString()))
//                .andExpect(jsonPath("$.semesterEndDate").value(res.getSemesterEndDate().toString()))
//                .andDo(print());
//
//        verify(service).semesterIns(any());
//
//    }
//
//    @Test
//    void getSemester() throws Exception {
//
//        List<AdminGetSemesterVo> list =new ArrayList<>();
//        AdminGetSemesterVo vo = new AdminGetSemesterVo();
//        vo.setIsemester(1L);
//        vo.setSemester(1);
//        vo.setYear("2024");
//        vo.setSemesterStrDate(LocalDate.now());
//        vo.setSemesterEndDate(LocalDate.of(2024,12,25));
//        list.add(vo);
//        AdminGetSemesterVo vo1 = new AdminGetSemesterVo();
//        vo1.setIsemester(2L);
//        vo1.setSemester(2);
//        vo1.setYear("2024");
//        vo1.setSemesterStrDate(LocalDate.now());
//        vo1.setSemesterEndDate(LocalDate.of(2024,12,25));
//        list.add(vo1);
//        String result = objectMapper.writeValueAsString(list);
//        when(service.getSemester(any())).thenReturn(list);
//
//        mvc.perform(get(path+"/semester")
//                .param("page","1")
//                .content(result))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("$.[0].isemester").value(vo.getIsemester()))
//                .andExpect(jsonPath("$.[0].semesterStrDate").value(vo.getSemesterStrDate().toString()))
//                .andExpect(jsonPath("$.[0].semesterEndDate").value(vo.getSemesterEndDate().toString()))
//                .andExpect(jsonPath("$.[1].isemester").value(vo1.getIsemester()))
//                .andExpect(jsonPath("$.[1].semesterStrDate").value(vo1.getSemesterStrDate().toString()))
//                .andExpect(jsonPath("$.[1].semesterEndDate").value(vo1.getSemesterEndDate().toString()))
//
//                .andDo(print());
//
//        verify(service).getSemester(any());
//
//
//
//    }
//
//    @Test
//    void findProfessors() throws Exception{
//        List<AdminLectureInStudentRes>list = new ArrayList<>();
//        AdminLectureInStudentRes res = new AdminLectureInStudentRes();
//        res.setIstudent(1L);
//        res.setNm("민용리");
//        res.setGread("A");
//        res.setMinEx(20);
//        res.setFinEx(30);
//        res.setAvg(4.5);
//        res.setMajorNm("초전도학");
//        res.setTotalScore(65);
//        res.setAttendance(15);
//        AdminLectureInStudentRes res1 = new AdminLectureInStudentRes();
//        res1.setIstudent(1L);
//        res1.setNm("민용리");
//        res1.setGread("A");
//        res1.setMinEx(20);
//        res1.setFinEx(30);
//        res1.setAvg(4.5);
//        res1.setMajorNm("초전도학");
//        res1.setTotalScore(65);
//        res1.setAttendance(15);
//
//        list.add(res1);
//
//        AdminLectureStudentResm resm = new AdminLectureStudentResm();
//        resm.setList(list);
//
//
//       // when(service.findLectureStudent(any())).thenReturn(ResponseEntity.ok().body(resm));
//
//    }
//
//    @Test
//    void selLecture() throws Exception {
//        List<AdminSelLectureRes> res= new ArrayList<>();
//        AdminSelLectureRes vo= new AdminSelLectureRes();
//        vo.setIlecture(1L);
//        vo.setNm("호");
//        vo.setLectureNm("이것저것");
//        vo.setProcedures(2);
//        vo.setStrDate(LocalDate.now());
//        vo.setEndDate(LocalDate.of(2030,10,20));
//        vo.setEndTime("10:20");
//        vo.setEndTime("11:20");
//        res.add(vo);
//        AdminSelLectureRes vo1= new AdminSelLectureRes();
//        vo1.setIlecture(2L);
//        vo1.setNm("불");
//        vo1.setLectureNm("이것저것");
//        vo1.setProcedures(2);
//        vo1.setStrDate(LocalDate.now());
//        vo1.setEndDate(LocalDate.of(2030,10,20));
//        vo1.setEndTime("10:20");
//        vo1.setEndTime("11:20");
//
//        res.add(vo1);
//        PagingUtils utils = new PagingUtils(1,10);
//
//        AdminSelRes build = AdminSelRes.builder().lectures(res).page(utils).build();
//
//        when(service.selLecture(any())).thenReturn(build);
//
//        String s = objectMapper.writeValueAsString(build);
//
//        mvc.perform(get(path+"/lecture")
//                .param("page","1").content(s))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("$.lectures[0].ilecture").value(1L))
//                .andExpect(jsonPath("$.lectures[0].nm").value(vo.getNm()))
//                .andExpect(jsonPath("$.lectures[0].lectureNm").value(vo.getLectureNm()))
//                .andExpect(jsonPath("$.lectures[1].ilecture").value(2L))
//                .andExpect(jsonPath("$.lectures[1].nm").value(vo1.getNm()))
//                .andExpect(jsonPath("$.lectures[1].lectureNm").value(vo1.getLectureNm()))
//                .andDo(print());
//
//
//
//        verify(service).selLecture(any());
//
//
//    }
//
//    @Test
//    void updLecture() throws Exception {
//        AdminUpdLectureDto dto= new AdminUpdLectureDto();
//        dto.setIlecture(1L);
//        dto.setProcedures(2);
//
//        AdminUpdLectureRes res = new AdminUpdLectureRes(dto);
//
//        when(service.lectureModify(dto)).thenReturn(res);
//
//        String valueAsString = objectMapper.writeValueAsString(dto);
//
//        ResultActions perform = mvc.perform(patch(path + "/lecture").contentType(MediaType.APPLICATION_JSON).content(valueAsString));
//
//        perform.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("$.ilecture").value(dto.getIlecture()))
//                .andExpect(jsonPath("$.procedures").value(dto.getProcedures()))
//                .andDo(print());
//
//        verify(service).lectureModify(dto);
//    }
//}