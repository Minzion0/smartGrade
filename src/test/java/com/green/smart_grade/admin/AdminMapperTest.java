package com.green.smart_grade.admin;

import com.green.smart_grade.admin.model.AdminSelLectureDto;
import com.green.smart_grade.admin.model.AdminSelLectureRes;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@ActiveProfiles("test")
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AdminMapperTest {
    @Autowired
    private  AdminMapper mapper;
    @Test
    void selLecture() {
        AdminSelLectureDto dto = new AdminSelLectureDto();
        dto.setStrIdx(0);
        dto.setRow(10);

        List<AdminSelLectureRes> res = mapper.selLecture(dto);
        log.info("res 1 :{}",res.get(1));
    }

    @Test
    void countLceture() {
    }

    @Test
    void lectureModify() {
    }

    @Test
    void updLecture() {
    }

    @Test
    void lectureInStudent() {
    }

    @Test
    void lectureCountStudent() {
    }
}