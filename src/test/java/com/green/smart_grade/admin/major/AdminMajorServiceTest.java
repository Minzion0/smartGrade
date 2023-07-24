package com.green.smart_grade.admin.major;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@Import({AdminMajorService.class})
class AdminMajorServiceTest {

    @MockBean
    private AdminMajorMapper mapper;

    @Autowired
    private AdminMajorService service;


    @Test
    void insMajor() {
        when(mapper.insMajor(any())).thenReturn(3);
    }

    @Test
    void selMajor() {
    }

    @Test
    void selMajorDetail() {
    }

    @Test
    void delMajor() {
    }
}