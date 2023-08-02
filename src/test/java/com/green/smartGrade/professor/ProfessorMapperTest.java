package com.green.smartGrade.professor;

import com.green.smartGrade.professor.model.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;
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

//    @Test
//    void selProfessor() {
//        ProfessorSelDto dto = new ProfessorSelDto();
//        dto.setStartIdx(0);
//        dto.setRow(10);
//        dto.setIprofessor(100007L);
//
//        List<ProfessorVo> list = new ArrayList<>();
//
//        // 교수 정보를 생성하여 list에 추가
//        ProfessorVo vo = new ProfessorVo(100007L, 2L, "sㅇㄴㅁ", 'F', "사진URL", LocalDate.of(2023, 07, 21), "010-123-456", "ASD@naver.com", "아앙");
//        list.add(vo);
//
//        ProfessorVo resultVo = list.get(0);
//        assertEquals(100007L, resultVo.getIprofessor());
//        assertEquals(2, resultVo.getImajor());
//        assertEquals("sㅇㄴㅁ", resultVo.getName());
//        assertEquals('F', resultVo.getGender());
//        assertEquals(LocalDate.of(2023, 07, 21), resultVo.getBirthdate());
//        assertEquals("010-123-456", resultVo.getPhone());
//        assertEquals("ASD@naver.com", resultVo.getEmail());
//        assertEquals("아앙", resultVo.getAddress());
//    }

//
//
//
//    @Test
//    void professorCount() {
//    }
//
//    @Test
//    void upProfessorPw() {
//        ProfessorUpPW pw2 = new ProfessorUpPW();
//        pw2.setIprofessor(10009L);
//        pw2.setPassword("1234");
//
//        int result2 = mapper.upProfessorPw(pw2);
//        assertEquals(0,result2);
//
//
//
//        ProfessorUpPW pw = new ProfessorUpPW();
//        pw.setIprofessor(100029L);
//        pw.setPassword("123");
//
//        int result = mapper.upProfessorPw(pw);
//        assertEquals(1,result);
//
//
//        ProfessorUpPW pw3 = new ProfessorUpPW();
//        pw3.setIprofessor(100021L);
//        pw3.setPassword("1234");
//
//        int result3 = mapper.upProfessorPw(pw3);
//        assertEquals(1,result3);
//
//    }
//
//    @Test
//    void upProfessor() {
//        ProfessorUpDto dto = new ProfessorUpDto();
//        dto.setAddress("1");
//        dto.setImajor(1L);
//        dto.setIprofessor(100029L);
//        dto.setPhone("010-456-321");
//        dto.setEmail("zkqi@naveer.com");
//
//        int result = mapper.upProfessor(dto);
//        assertEquals(1,result);
//
//
//        ProfessorUpDto dto2 = new ProfessorUpDto();
//        dto2.setAddress("2");
//        dto2.setImajor(2L);
//        dto2.setIprofessor(100007L);
//        dto2.setPhone("010-4567-8521");
//        dto2.setEmail("zkqi@naver.com");
//
//        int result2 = mapper.upProfessor(dto2);
//        assertEquals(1,result2);
//
//
//
//
//    }
//
//    @Test
//    void selAllProfessor() {
//        List<ProfessorVo> list = new ArrayList<>();
//        list.add(new ProfessorVo(100007L, 2L, "sㅇㄴㅁ", 'F', "jfa.jps"
//                , LocalDate.of(2023, 07, 21), "010-456-456", "zkweq@naver.com", "대구시"));
//
//        ProfessorVo vo = list.get(0);
//        assertEquals(100007L,vo.getIprofessor());
//        assertEquals(2,vo.getImajor());
//        assertEquals("sㅇㄴㅁ",vo.getName());
//        assertEquals('F',vo.getGender());
//        assertEquals(LocalDate.of(2023, 07, 21),vo.getBirthdate());
//        assertEquals("010-456-456",vo.getPhone());
//        assertEquals("zkweq@naver.com",vo.getEmail());
//        assertEquals("대구시",vo.getAddress());
//
//        list.add(new ProfessorVo(100009L, 14L, "sㅇㄴㅁ", 'F', "jfa.jps"
//                , LocalDate.of(2023, 07, 21), "010-1234-5675", "dsa@das.com", "대구시"));
//
//        ProfessorVo vo2 = list.get(1);
//        assertEquals(100009L,vo2.getIprofessor());
//        assertEquals(14,vo2.getImajor());
//        assertEquals("sㅇㄴㅁ",vo2.getName());
//        assertEquals('F',vo2.getGender());
//        assertEquals(LocalDate.of(2023, 07, 21),vo2.getBirthdate());
//        assertEquals("010-1234-5675",vo2.getPhone());
//        assertEquals("dsa@das.com",vo2.getEmail());
//        assertEquals("대구시",vo2.getAddress());
//
//    }
//
//    @Test
//    void upPicProfessor() {
//        ProfessorPicDto dto = new ProfessorPicDto();
//        dto.setIprofessor(100007L);
//        dto.setPic("sel.jpg");
//
//        int result = mapper.upPicProfessor(dto);
//        assertEquals(1,result);
//
//        ProfessorPicDto dto1 = new ProfessorPicDto();
//        dto1.setIprofessor(100009L);
//        dto1.setPic("sel.jpg");
//
//        int result1 = mapper.upPicProfessor(dto1);
//        assertEquals(1,result1);
//    }
//
//    @Test
//    void selProfessorLecture() {
//    }
//
//    @Test
//    void selProfessorLectureALl() {
//    }
//
//    @Test
//    void selProfessorLectureCount() {
//    }
}