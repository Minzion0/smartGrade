package com.green.smartGrade.professor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.green.smartGrade.professor.model.*;
import com.green.smartGrade.security.config.security.model.MyUserDetails;
import com.green.smartGrade.utils.PagingUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//import static org.mockito.ArgumentMatchers.any;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import static org.mockito.ArgumentMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProfessorController.class)
class ProfessorControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProfessorService service;


    @BeforeEach
    void beforeEach() {
        UserDetails user = createUserDetails();

        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities()));

    }
    private UserDetails createUserDetails() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_PROFESSOR");


        UserDetails userDetails = MyUserDetails.builder()
                .iuser(100029L)
                .roles(roles)
                .build();
        return userDetails;
    }




    @Test
    void getProfessor() throws Exception{

        ProfessorMajor major = new ProfessorMajor();
        major.setIlecture(4L);
        major.setLectureStrDate(LocalDate.of(2023, 3, 4));
        major.setLectureEndDate(LocalDate.of(2023, 6, 30));
        major.setLectureStrTime("09:00:00");
        major.setLectureEndTime("10:00:00");
        major.setLectureName("물리학");

        ProfessorDatilProfile profile = new ProfessorDatilProfile();
        profile.setIprofessor(100029L);
        profile.setName("김재경");
        profile.setSecretKey("null");
        profile.setAddress("eorn");
        profile.setEmail("orud2312@Qwe");
        profile.setPic("professor/100029/1bfa7e0b-a95e-4eec-9ad1-31e69f948a83.jpg");
        profile.setPhone("010-5800-0768");
        profile.setBirthdate("2023-07-24");
        profile.setImajor(20L);
        profile.setGender("F");
        profile.setCreatedAt(LocalDateTime.of(2023,7,24,11,07,00));

        ProfessoreDatailProFileVo mockResponse = ProfessoreDatailProFileVo.builder()
                .lectureList(List.of(major))
                .profile(profile)
                .build();

        // Mocking service.selProfessor() 호출
        given(service.selProfessor(any())).willReturn(mockResponse);

        // MyUserDetails 객체 생성 및 Authentication 생성
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_PROFESSOR");
        MyUserDetails userDetails = MyUserDetails.builder()
                .iuser(100029L)
                .userNum("100029L")
                .roles(roles)
                .uid("100029L")
                .upw("65f5450b98a689b6ca662c53e394eb27872c62f207104bae90bb0c8fb86eb69c")
                .build();
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null);

        // MockMvc를 사용하여 GET 요청 실행
        mvc.perform(get("/api/professor")
                        .principal(authentication))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lectureList[0].ilecture").value(4L))
                .andExpect(jsonPath("$.profile.iprofessor").value(100029L))
                .andExpect(jsonPath("$.profile.name").value("김재경"))

                .andDo(print());

        // service.selProfessor() 메서드가 dto와 함께 호출되는지 확인
        verify(service).selProfessor(any(ProfessorSelDto.class));
    }


    @Test
    void putPicProfessor() throws  Exception{
        MockMultipartFile pic = new MockMultipartFile(
                "pic", "test.jpg", MediaType.MULTIPART_FORM_DATA_VALUE, "main.image".getBytes());


        ProfessorUpRes mockResponse = new ProfessorUpRes();
        given(service.upProfessor(any(MultipartFile.class), any(ProfessorParam.class))).willReturn(mockResponse);




        mvc.perform(multipart("/api/professor/pic")
                        .file(pic)
                        .param("phone", "010-1234-5678")
                        .param("email", "test@ex.com")
                        .param("address", "das")
                        .with(csrf())
                        .with(user("100029L").roles("PROFESSOR")))
                .andExpect(status().isOk())
                .andDo(print());


        verify(service).upProfessor(any(MultipartFile.class), any(ProfessorParam.class));

    }

    @Test
    void selProfessorLecture() throws Exception{

        List<ProfessorSelLectureVo> mockLectures = new ArrayList<>(); // Mock 데이터 생성
        mockLectures.add(new ProfessorSelLectureVo("09:00:00", "10:00:00",
                "2023-03-04", "2023-06-23", 0, 3,
                "물리학1", 1, "503호", 27, "5", 21));

        SelProfessorRes mockResponse = SelProfessorRes.builder()
                .list(mockLectures)
                .page(new PagingUtils())
                .build();

        given(service.selProfessorLecture(any(ProfessorSelLectureDto.class))).willReturn(mockResponse);

        mvc.perform(get("/api/professor/lecture-List")
                        .param("page", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.list", hasSize(mockLectures.size())))
                .andDo(print());

        verify(service).selProfessorLecture(any(ProfessorSelLectureDto.class));
    }




    @Test
    void updPassword() {



    }

    @Test
    void deleteFile() {
    }
}


