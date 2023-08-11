//package com.green.smartGrade.admin.grade_mngmn;
//
//import com.green.smartGrade.admin.grade_mngmn.model.*;
//import org.junit.jupiter.api.Test;
//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//@MybatisTest
//@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class GradeMngmnMapperTest {
//
//    @Autowired
//    private GradeMngmnMapper mapper;
//
//    @Test
//    void selGradeFindStudentDetail() {
//        GradeMngmnDetailSelDto dto = new GradeMngmnDetailSelDto();
//        dto.setIstudent(1L);
//        GradeMngmnDetailVo vo = mapper.selGradeFindStudentDetail(dto);
//
//        assertEquals("23100001", vo.getStudentNum());
//        assertEquals(vo.getGender(), "F");
//        assertEquals(vo.getEmail(), "dkai@namve.com");
//        assertEquals(vo.getName(), "재경킴");
//        assertEquals(vo.getAddress(), "대구어딘");
//        assertEquals(vo.getPic(),"b9f4aa36-bc02-44b4-a6d5-931413b7e51b.jpg");
//
//        GradeMngmnDetailSelDto dto2 = new GradeMngmnDetailSelDto();
//        dto2.setIstudent(3L);
//        GradeMngmnDetailVo vo2 = mapper.selGradeFindStudentDetail(dto2);
//
//        assertEquals("23100002", vo2.getStudentNum());
//        assertEquals(vo2.getGender(), "F");
//        assertEquals(vo2.getEmail(), "aert12341@naver.com");
//        assertEquals(vo2.getName(), "지녹제");
//        assertEquals(vo2.getAddress(), "대구시어쩌고저쩌고");
//        assertEquals(vo2.getPic(),null);
//    }
//
//    @Test
//    void selGradeFindStudent() {
//        GradeMngmnAvgDto dto = new GradeMngmnAvgDto();
//        List<GradeMngmnVo> voList = mapper.selGradeFindStudent(dto);
//
//        int grade = voList.get(0).getGrade();
//        int totalScore = voList.get(0).getTotalScore();
//        String rating = voList.get(0).getRating();
//        String lectureName = voList.get(0).getLectureName();
//
//        assertEquals(3, grade);
//        assertEquals(55, totalScore);
//        assertEquals(dto.getRating(), rating);
//        assertEquals(lectureName, "물리학실험");
//    }
//
//    @Test
//    void gradeMngmnAvg() {
//        GradeMngmnAvgDto dto = new GradeMngmnAvgDto();
//        List<GradeMngmnAvgVo> voList = mapper.GradeMngmnAvg(dto);
//
//        GradeMngmnAvgVo vo = voList.get(0);
//        assertEquals(vo.getSemester(),1);
//        assertEquals(vo.getAvgScore(), 38);
//        assertEquals(vo.getAvgRating(), 4.5);
//        assertEquals(vo.getGrade(), 3);
//    }
//}