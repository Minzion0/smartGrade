package com.green.smartGrade.admin;


import com.green.smartGrade.admin.model.*;
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

class AdminMapperTest {
    @Autowired
    private AdminMapper mapper;

    @Test
    void selLecture(){
        AdminSelLectureDto dto = new AdminSelLectureDto();
        dto.setRow(10);
        dto.setStrIdx(0);
        dto.setProcedures(0);
        List<AdminSelLectureRes> adminSelLectureRes = mapper.selLecture(dto);
        int size = adminSelLectureRes.size();
        Assertions.assertEquals(6,size);
        AdminSelLectureRes res = adminSelLectureRes.get(0);
        Long ilecture = res.getIlecture();
        assertEquals(4,ilecture);

        AdminSelLectureDto dto2 = new AdminSelLectureDto();
        dto2.setRow(10);
        dto2.setStrIdx(0);
        dto2.setProcedures(-2);
        List<AdminSelLectureRes> adminSelLectureRes2 = mapper.selLecture(dto2);
        int size2 = adminSelLectureRes2.size();
        Assertions.assertEquals(10,size2);
        AdminSelLectureRes res2 = adminSelLectureRes2.get(0);
        Long ilecture2 = res2.getIlecture();
        assertEquals(4,ilecture2);
    }

    @Test
    void countLceture(){
        AdminSelLectureDto dto = new AdminSelLectureDto();
        dto.setRow(10);
        dto.setStrIdx(0);
        dto.setProcedures(0);
        int i = mapper.countLceture(dto);
        assertEquals(i,6);

        AdminSelLectureDto dto2 = new AdminSelLectureDto();
        dto2.setRow(10);
        dto2.setStrIdx(0);
        dto2.setProcedures(-2);
        int i1 = mapper.countLceture(dto2);
        assertEquals(i1,42);
    }

    @Test
    void lectureInStudent(){
        AdminLectureInStudentDto dto = new AdminLectureInStudentDto();
        dto.setIlecture(4L);


        List<AdminLectureInStudentRes> res = mapper.lectureInStudent(dto);
        int size = res.size();
        assertEquals(size,8);

        AdminLectureInStudentDto dto2 = new AdminLectureInStudentDto();
        dto2.setIlecture(5L);

        List<AdminLectureInStudentRes> res1 = mapper.lectureInStudent(dto2);
        int size1 = res1.size();
        assertEquals(size1,5);

        AdminLectureInStudentRes lecture = res1.get(0);
        Long istudent = lecture.getIstudent();
        String nm = lecture.getNm();
        int score = lecture.getTotalScore();
        assertEquals(istudent,6);
        assertEquals(nm,"지코바");
        assertEquals(score,30);


    }

    @Test
    void lectureModify(){
        AdminUpdLectureDto dto = new AdminUpdLectureDto();
        dto.setIlecture(1L);
        dto.setProcedures(2);
        int i = mapper.updLecture(dto);

        Assertions.assertEquals(i,1);
    }

}