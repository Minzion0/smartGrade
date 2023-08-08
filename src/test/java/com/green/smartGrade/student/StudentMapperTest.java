package com.green.smartGrade.student;

import com.green.smartGrade.student.model.StudentInsDto;
import com.green.smartGrade.student.model.StudentInsRes;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

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

        assertEquals(63,dto.getIlecture());
        assertEquals(1,result);



    }
}