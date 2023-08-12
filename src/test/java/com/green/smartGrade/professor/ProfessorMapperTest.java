//package com.green.smartGrade.professor;
//
//import com.green.smartGrade.professor.model.*;
//import org.junit.jupiter.api.Test;
//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//@MybatisTest
//@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class ProfessorMapperTest {
//
//    @Autowired
//    private ProfessorMapper mapper;
//
//    @Test
//    void upProfessor() {
//        ProfessorUpDto dto = new ProfessorUpDto();
//        dto.setIprofessor(100007L);
//        dto.setPhone("010-456");
//        dto.setEmail("zka@na.com");
//        dto.setAddress("주소");
//        dto.setPic("사진.jpg");
//
//        int result = mapper.upProfessor(dto);
//        assertEquals(1,result);
//
//        ProfessorUpDto dto1 = new ProfessorUpDto();
//        dto1.setIprofessor(100009L);
//        dto1.setPhone("010-111");
//        dto1.setEmail("zads@na.com");
//        dto1.setAddress("수정");
//        dto1.setPic("파일.jpg");
//
//        int result1 = mapper.upProfessor(dto1);
//        assertEquals(1,result1);
//
//    }
//
//
//    @Test
//    void selProfessorLecture() {
//        ProfessorSelLectureDto dto = new ProfessorSelLectureDto();
//        dto.setPage(1);
//        dto.setStaIdx(1);
//        dto.setOpeningProcedures("0");
//        dto.setIprofessor(100007L);
//
//        List<ProfessorSelLectureVo> vo = mapper.selProfessorLecture(dto);
//        assertEquals(4,vo.size());
//
//
//        ProfessorSelLectureDto dto1 = new ProfessorSelLectureDto();
//        dto1.setPage(1);
//        dto1.setStaIdx(1);
//        dto1.setOpeningProcedures("0");
//        dto1.setIprofessor(100009L);
//
//        List<ProfessorSelLectureVo> vo1 = mapper.selProfessorLecture(dto1);
//        assertEquals(0,vo1.size());
//
//
//    }
//
//
//    @Test
//    void selProfessorLectureCount() {
//        ProfessorSelLectureDto dto = new ProfessorSelLectureDto();
//        dto.setIprofessor(100007L);
//        dto.setPage(1);
//        dto.setStaIdx(1);
//        dto.setOpeningProcedures("0");
//
//        int result = mapper.selProfessorLectureCount(dto);
//        assertEquals(5,result);
//
//
//        ProfessorSelLectureDto dto1 = new ProfessorSelLectureDto();
//        dto1.setIprofessor(100029L);
//        dto1.setPage(1);
//        dto1.setStaIdx(1);
//        dto1.setOpeningProcedures("0");
//
//        int result1 = mapper.selProfessorLectureCount(dto1);
//        assertEquals(1,result1);
//
//    }
//
//
//    @Test
//    void updPassword() {
//        ProfessorUpdPasswordDto dto = new ProfessorUpdPasswordDto();
//        dto.setProfessorPassword("1234");
//        dto.setIprofessor(100007L);
//        dto.setRole("ROLE_PROFESSOR");
//
//        int result = mapper.updPassword(dto);
//        assertEquals(1,result);
//
//        ProfessorUpdPasswordDto dto1 = new ProfessorUpdPasswordDto();
//        dto1.setProfessorPassword("12345");
//        dto1.setIprofessor(100029L);
//        dto1.setRole("ROLE_PROFESSOR");
//
//        int result1 = mapper.updPassword(dto1);
//        assertEquals(1,result1);
//    }
//
//    @Test
//    void picFilePathByProfessor() {
//        Long iprofessor = 100007L;
//
//        String result = mapper.picFilePathByProfessor(iprofessor);
//        assertEquals("1442ae49-1579-4242-bd4c-682b4d0925f4.png",result);
//
//
//        Long iprofessor1 = 100027L;
//
//        String result1 = mapper.picFilePathByProfessor(iprofessor1);
//        assertEquals("professor/100027/a535de38-7cd8-4bf5-b06e-9b6a45e47e4e.jpg",result1);
//
//    }
//
//
//    @Test
//    void updateFilePathNullByProfessor() {
//        Long iprofessor = 100007L;
//
//       mapper.updateFilePathNullByProfessor(iprofessor);
//
//    }
//
//
//    @Test
//    void selPasswordCurrent() {
//        ProfessorSelCurrentPasswordDto dto = new ProfessorSelCurrentPasswordDto();
//        dto.setIprofessor(100007L);
//        dto.setRole("ROLE_PROFESSOR");
//
//        ProfessorSelCurrentPasswordVo vo = mapper.selPasswordCurrent(dto);
//        assertEquals("{bcrypt}$2a$10$8Qr6J57BbEcsmEfpNjdkZeKFEkmI8hfbBZqewQ7ey30fAqAyHcvby",vo.getCurrentStudentPassword());
//
//    }
//
//
//    @Test
//    void selProfessor() {
//        ProfessorSelDto dto = new ProfessorSelDto();
//        dto.setIprofessor(100007L);
//
//        ProfessorDatilProfile vo = mapper.selProfessor(dto);
//        assertEquals("sㅇㄴㅁ", vo.getName());
//        assertEquals("F", vo.getGender());
//        assertEquals("2023-07-21",vo.getBirthdate());
//        assertEquals(2,vo.getImajor());
//        assertEquals("대구 어딘가",vo.getAddress());
//        assertEquals("010-9999-8888", vo.getPhone());
//        assertEquals("pppp@naver.com",vo.getEmail());
//        assertEquals("1442ae49-1579-4242-bd4c-682b4d0925f4.png",vo.getPic());
//        assertEquals(LocalDateTime.of(2023,7,21,16,59,53),vo.getCreatedAt());
//    }
//
//    @Test
//    void professorMajor() {
//        ProfessorSelDto dto = new ProfessorSelDto();
//        dto.setIprofessor(100007L);
//
//
//        List<ProfessorMajor> vo = mapper.professorMajor(dto);
//        assertEquals(17,vo.size());
//
//
//
//        ProfessorSelDto dto1 = new ProfessorSelDto();
//        dto1.setIprofessor(100009L);
//
//
//        List<ProfessorMajor> vo1 = mapper.professorMajor(dto1);
//        assertEquals(2,vo1.size());
//
//
//
//    }
//}