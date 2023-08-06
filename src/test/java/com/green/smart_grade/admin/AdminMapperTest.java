package com.green.smart_grade.admin;


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

    @Test
    void selLecture() {

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