//package com.green.smartGrade.admin.major;
//
//import com.green.smartGrade.admin.major.model.*;
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
//class AdminMajorMapperTest {
//
//    @Autowired
//    private AdminMajorMapper mapper;
//
//    @Test
//    void insMajor() {
//        MajorInsDto dto = new MajorInsDto();
//        MajorSelDto dto2 = new MajorSelDto();
//        dto.setMajorName("무화과과");
//        dto.setGraduationScore(130);
//
//        int result = mapper.insMajor(dto);
//
//        assertEquals(1,result);
//
//    }
//
//    @Test
//    void selMajor() {
//        MajorSelDto dto = new MajorSelDto();
//        List<MajorVo> list = mapper.selMajor(dto);
//
//        String majorName = list.get(0).getMajorName();
//        int graduationScore = list.get(0).getGraduationScore();
//        String remarks = list.get(0).getRemarks();
//
//        assertEquals("q과", majorName);
//        assertEquals(120, graduationScore);
//        assertEquals("구 ㅇㅇ", remarks);
//    }
//
//    @Test
//    void updMajor() {
//        MajorUpdDto dto = new MajorUpdDto();
//        dto.setMajorName("0과과과");
//        dto.setImajor(1L);
//
//        int result = mapper.updMajor(dto);
//
//        assertEquals(1,result);
//    }
//
//    @Test
//    void delMajor() {
//        MajorDelDto dto = new MajorDelDto();
//        MajorSelDto dto2 = new MajorSelDto();
//        dto.setImajor(1L);
//
//        int result = mapper.delMajor(dto);
//
//        assertEquals(1, result);
//
//        List<MajorVo> list = mapper.selMajor(dto2);
//        MajorVo majorVo = list.get(0);
//
//        assertEquals(majorVo.getDelYn(), 1);
//    }
//}