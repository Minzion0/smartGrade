//package com.green.smartGrade.admin.major;
//
//import com.green.smartGrade.admin.major.model.*;
//import com.green.smartGrade.utils.PagingUtils;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.swing.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//@Import({AdminMajorService.class})
//class AdminMajorServiceTest {
//
//    @MockBean
//    private AdminMajorMapper mapper;
//
//    @Autowired
//    private AdminMajorService service;
//
//    @Test
//    void insMajor() {
//        MajorInsParam p1 = new MajorInsParam();
//        p1.setMajorName("이걸로하지말과");
//        p1.setGraduationScore(130);
//
//        when(mapper.insMajor(any())).thenReturn(1);
//
//        MajorRes r1 = service.insMajor(p1);
//
//        assertEquals(r1.getMajorName(), p1.getMajorName());
//        assertEquals(r1.getGraduationScore(), p1.getGraduationScore());
//
//        verify(mapper).insMajor(any());
//    }
//
//    @Test
//    void selMajor() {
//        MajorSelDto dto = new MajorSelDto();
//        List<MajorVo> voList = new ArrayList<>();
//        when(mapper.selMajor(any())).thenReturn(voList);
//
//        MajorfindRes res = service.selMajor(dto);
//
//        assertEquals(res.getMajor().get(0).getMajorName(),voList.get(0).getMajorName());
//
//    }
//
//    @Test
//    void delMajor() {
//        MajorDelDto dto = new MajorDelDto();
//
//        dto.setImajor(1L);
//
//        when(mapper.delMajor(any())).thenReturn(1);
//
//        int result = service.delMajor(dto);
//
//        assertEquals(result,dto.getImajor());
//
//        verify(mapper).delMajor(any());
//    }
//
//    @Test
//    void updMajor() {
//    }
//}