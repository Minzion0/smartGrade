/*
package com.green.smartGrade.student;

import com.green.smartGrade.student.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentMapperTest {

    @Autowired
    private StudentMapper mapper;

    @Test
    void insSdy() {
         StudentInsDto dto = new StudentInsDto();
            dto.setIlecture(10L);
            dto.setIstudent(14L);
            dto.setIlectureStudent(9L);
        int result = mapper.insSdy(dto);

        //assertEquals(64,dto.getIlectureStudent());
        assertEquals(1,result);

    }


    @Test
    void selAllSdy() {
        StudentSelDto dto = new StudentSelDto();
        dto.setStudentNum(23100001L);
        dto.setStartIdx(0);
        dto.setRow(10);

        List<StudentSelVo> list = mapper.selAllSdy(dto);
        int size = list.size();

        assertEquals(6,size);

        StudentSelVo vo = list.get(0);
        assertEquals(23100001, vo.getStudentNum());
    }


    @Test
    void selStudentProfile() {
        StudentSelProfileDto dto = new StudentSelProfileDto();
        dto.setStudentNum(23100001L);
        dto.setPage(1);
        dto.setStartIdx(0);
        dto.setRow(10);

        List<StudentSelProfileVo> list = mapper.selStudentProfile(dto);

        assertEquals(1, list.size());

        StudentSelProfileVo re = list.get(0);
        assertEquals(23100001,re.getStudentNum());



        StudentSelProfileDto dto2 = new StudentSelProfileDto();
        dto2.setStudentNum(23100002L);
        dto2.setPage(1);
        dto2.setStartIdx(0);
        dto2.setRow(10);

        List<StudentSelProfileVo> list2 = mapper.selStudentProfile(dto2);

        assertEquals(1, list2.size());

        StudentSelProfileVo re2 = list2.get(0);
        assertEquals(23100002,re2.getStudentNum());
        assertEquals("지녹제",re2.getNm());
    }


    @Test
    void selStudentRemainingPoint() {
        StudentSelPointDto dto = new StudentSelPointDto();
        dto.setPage(1);
        dto.setStartIdx(0);
        dto.setRow(10);
        dto.setStudentNum(2310010L);

        List<StudentSelPointVo> list = mapper.selStudentRemainingPoint(dto);
        assertEquals(1, list.size());

        StudentSelPointVo vo = list.get(0);
        assertEquals(2310010 , vo.getStudentNum());
        assertEquals(13, vo.getIstudent());
        assertEquals(20, vo.getImajor());
        assertEquals(1, vo.getFinishedYn());
        assertEquals(1, vo.getScore());
        assertEquals(130, vo.getGraduationScore());
        assertEquals(129, vo.getRemainingPoints());
        assertEquals(3, vo.getGrade());
    }


    @Test
    void upStudent() {
        StudentUpdto dto = new StudentUpdto();
        dto.setIstudent(13L);
        dto.setPhone("010-222-444");
        dto.setAddress("몰라");
        dto.setEmail("akak@am.com");
        dto.setPic("main.jpg");

        int r1 = mapper.upStudent(dto);
        assertEquals(1, r1);

        StudentUpdto dto2 = new StudentUpdto();
        dto2.setIstudent(24L);
        dto2.setPhone("010-7777-5564");
        dto2.setAddress("어디");
        dto2.setEmail("aloq@am.com");
        dto2.setPic("main.jpg");

        int r2 = mapper.upStudent(dto2);
        assertEquals(1, r2);

    }



}*/
