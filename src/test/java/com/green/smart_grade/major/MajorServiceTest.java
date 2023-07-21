package com.green.smart_grade.major;

import com.green.smart_grade.major.model.MajorInsDto;
import com.green.smart_grade.major.model.MajorInsParam;
import com.green.smart_grade.major.model.MajorRes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import({MajorService.class})
class MajorServiceTest {

    @MockBean
    private MajorMapper MAPPER;

    @Autowired
    private MajorService SERVICE;

    @Test
    void insMajor() {
//        when(MAPPER.insMajor(any())).thenReturn(1);
//
//        MajorInsParam p = new MajorInsParam();
//        p.setMajorName("기계공학과");
//        p.setGraduationScore(100);
//
//        MajorRes res = SERVICE.insMajor(p);
//        assertEquals(1, res);
//
//        verify(MAPPER).insMajor(any());
    }
}