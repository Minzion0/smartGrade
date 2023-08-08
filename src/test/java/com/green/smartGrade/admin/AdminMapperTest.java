package com.green.smartGrade.admin;


import com.green.smartGrade.admin.model.AdminSelLectureDto;
import com.green.smartGrade.admin.model.AdminSelLectureRes;
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
        List<AdminSelLectureRes> adminSelLectureRes = mapper.selLecture(dto);
        int size = adminSelLectureRes.size();
        Assertions.assertEquals(6,size);
        AdminSelLectureRes res = adminSelLectureRes.get(0);
        Long ilecture = res.getIlecture();
        assertEquals(4,ilecture);
    }
}