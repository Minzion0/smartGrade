package com.green.smartGrade.professor;

import com.green.smartGrade.professor.model.ProfessorSelDto;
import com.green.smartGrade.professor.model.ProfessorUpDto;
import com.green.smartGrade.professor.model.ProfessorUpPW;
import com.green.smartGrade.professor.model.ProfessorVo;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProfessorMapperTest {

    @Autowired
    private ProfessorMapper mapper;

    @Test
    void selProfessor() {

    }

    @Test
    void professorCount() {
    }

    @Test
    void upProfessorPw() {
        ProfessorUpPW pw = new ProfessorUpPW();
        pw.setIprofessor(100029L);
        pw.setPassword("123");

        int result = mapper.upProfessorPw(pw);
        assertEquals(1,result);

    }

    @Test
    void upProfessor() {
        ProfessorUpDto dto = new ProfessorUpDto();
        dto.setAddress("1");
        dto.setImajor(1L);
        dto.setIprofessor(100029L);
        dto.setPhone("010-456-321");
        dto.setEmail("zkqi@naveer.com");

        int result = mapper.upProfessor(dto);
        assertEquals(1,result);



    }

    @Test
    void selAllProfessor() {
        int staIdx = 0;
        List<ProfessorVo> list = new ArrayList<>();
        list.add(new ProfessorVo(100007L, 2L, "sㅇㄴㅁ", 'F', "jfa.jps"
                , LocalDate.of(2023, 07, 21), "010-456-456", "zkweq@naver.com", "대구시"));

        ProfessorVo vo = list.get(0);
        assertEquals(2,vo.getImajor());
        assertEquals("sㅇㄴㅁ",vo.getName());
        assertEquals('F',vo.getGender());




    }

    @Test
    void upPicProfessor() {
    }

    @Test
    void selProfessorLecture() {
    }

    @Test
    void selProfessorLectureALl() {
    }

    @Test
    void selProfessorLectureCount() {
    }
}