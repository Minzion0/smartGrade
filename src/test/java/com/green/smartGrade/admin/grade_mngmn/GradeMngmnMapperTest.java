package com.green.smartGrade.admin.grade_mngmn;

import com.green.smartGrade.admin.grade_mngmn.model.GradeMngmnDetailSelDto;
import com.green.smartGrade.admin.grade_mngmn.model.GradeMngmnDetailVo;
import com.green.smartGrade.admin.grade_mngmn.model.GradeMngmnVo;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GradeMngmnMapperTest {

    @Autowired
    private GradeMngmnMapper mapper;

    @Test
    void selGradeFindStudentDetail() {
        GradeMngmnDetailSelDto dto = new GradeMngmnDetailSelDto();
        dto.setIstudent(1L);
        GradeMngmnDetailVo vo = mapper.selGradeFindStudentDetail(dto);

        assertEquals("23100001", vo.getStudentNum());
        assertEquals(vo.getGender(), "F");
        assertEquals(vo.getEmail(), "dkai@namve.com");
        assertEquals(vo.getName(), "재경킴");
        assertEquals(vo.getAddress(), "대구어딘");
        assertEquals(vo.getPic(),"b9f4aa36-bc02-44b4-a6d5-931413b7e51b.jpg");
    }

    @Test
    void selGradeFindStudentVo() {

    }
}