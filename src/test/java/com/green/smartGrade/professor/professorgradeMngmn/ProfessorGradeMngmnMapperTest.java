//package com.green.smartGrade.professor.professorgradeMngmn;
//
//import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeMngmnSelDto;
//import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeMngmnSelVo;
//import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeMngmnUpDto;
//import org.junit.jupiter.api.Test;
//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//@MybatisTest
//@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class ProfessorGradeMngmnMapperTest {
//
//    @Autowired
//    private ProfessorGradeMngmnMapper mapper;
//
//    @Test
//    void upMngnm() {
//        ProfessorGradeMngmnUpDto dto = new ProfessorGradeMngmnUpDto();
//        dto.setIpofessor(100029L);
//        dto.setIlectureStudent(3L);
//        dto.setIlecture(4L);
//        dto.setFinishedYn(1);
//        dto.setRating("A");
//        dto.setAttendance(20);
//        dto.setMidtermExamination(40);
//        dto.setFinalExamination(25);
//        dto.setPoint(85);
//
//        int result = mapper.upMngnm(dto);
//        assertEquals(1,result);
//
//    }
//
//    @Test
//    void selStudentScore() {
//        ProfessorGradeMngmnSelDto dto = new ProfessorGradeMngmnSelDto();
//        dto.setIprofessor(100029L);
//        dto.setStudentNum(2310003);
//        dto.setPage(1);
//        dto.setStaIdx(0);
//
//        List<ProfessorGradeMngmnSelVo> list = mapper.selStudentScore(dto);
//        assertEquals(1,list.size());
//        assertEquals(100029L,dto.getIprofessor());
//        assertEquals(2310003,dto.getStudentNum());
//
//    }
//
//    @Test
//    void selStudentScoreCount() {
//    }
//
//    @Test
//    void updAvgScore() {
//    }
//
//    @Test
//    void getMaxAttendance() {
//    }
//
//    @Test
//    void getMaxMidtermExamination() {
//    }
//
//    @Test
//    void getMaxFinalExamination() {
//    }
//}