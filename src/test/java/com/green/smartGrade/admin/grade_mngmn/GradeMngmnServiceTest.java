//package com.green.smartGrade.admin.grade_mngmn;
//
//import com.green.smartGrade.admin.grade_mngmn.model.*;
//import com.green.smartGrade.utils.PagingUtils;
//import org.apache.ibatis.annotations.Many;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.swing.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//@Import({GradeMngmnService.class})
//class GradeMngmnServiceTest {
//
//    @MockBean
//    private GradeMngmnMapper mapper;
//
//    @Autowired
//    private GradeMngmnService service;
//
//    @Test
//    void selGradeFindStudentVo() {
//        PagingUtils page = new PagingUtils(1, 10);
//        GradeMngmnStudentVo student = new GradeMngmnStudentVo();
//        List<GradeMngmnVo> voList = new ArrayList<>();
//        List<GradeMngmnAvgVo> avgVo = new ArrayList<>();
//        GradeMngmnAvgDto dto = new GradeMngmnAvgDto();
//
//
//        GradeMngmnDetailAvgVo result = GradeMngmnDetailAvgVo.builder()
//                .page(page)
//                .student(student)
//                .voList(voList)
//                .avgVo(avgVo)
//                .build();
//        when(mapper.selGradeFindStudentVo(any())).thenReturn(result);
//
//        GradeMngmnDetailAvgVo vo = service.selGradeFindStudentVo(dto);
//
//        assertNotNull(result);
//        assertEquals(page, result.getPage());
//        assertEquals(student, result.getStudent());
//        assertEquals(voList, result.getVoList());
//        assertEquals(avgVo, result.getAvgVo());
//    }
//
//    @Test
//    void selGradeFindStudentDetail() {
//    }
//}