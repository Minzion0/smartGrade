package com.green.smartGrade.professor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.smartGrade.professor.model.*;
import com.green.smartGrade.security.config.security.model.MyUserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProfessorController.class)
class ProfessorControllerTest {
    @Autowired

    @MockBean
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProfessorService service;

    @Test
    void getProfessor() throws Exception{

        ProfessorSelDto dto = new ProfessorSelDto();
        dto.setIprofessor(100029L);

        List<ProfessorMajor> lectureList = new ArrayList<>();
        ProfessorMajor major = new ProfessorMajor();
        major.setIlecture(4L);
        major.setLectureStrDate(LocalDate.of(2023,3,4));
        major.setLectureEndDate(LocalDate.of(2023, 6, 30));
        major.setLectureStrTime("09:00:00");
        major.setLectureEndTime("10:00:00");
        major.setLectureName("물리학"  );
        lectureList.add(major);


        ProfessorDatilProfile profile = new ProfessorDatilProfile();
        profile.setIprofessor(100029L);
        profile.setName("김재경");

        ProfessoreDatailProFileVo mockResponse = ProfessoreDatailProFileVo.builder()
                .lectureList(lectureList)
                .profile(profile)
                .build();

        given(service.selProfessor(dto)).willReturn((mockResponse));



        mvc.perform(get("/api/professor/profile"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.lectureList[0].ilecture").value(4L))
                .andExpect(jsonPath("$.profile.iprofessor").value(100029L))
                .andExpect(jsonPath("$.profile.name").value("김재경"))
                // ... (나머지 필드들도 추가)
                .andDo(print());

        verify(service).selProfessor(dto);
    }

    @Test
    void putPicProfessor() throws  Exception{

    }



    }


