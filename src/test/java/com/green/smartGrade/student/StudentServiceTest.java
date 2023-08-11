//package com.green.smartGrade.student;
//
//import com.green.smartGrade.student.model.StudentInsDto;
//import com.green.smartGrade.student.model.StudentInsRes;
//import com.green.smartGrade.student.model.StudentParam;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(SpringExtension.class)
//@Import({StudentService.class})
//class StudentServiceTest {
//
//    @MockBean
//    private StudentMapper mapper;
//
//    @Autowired
//    private StudentService service;
//
//    @MockBean
//    private PasswordEncoder passwordEncoder;
//
//
//    @Test
//    void dayWeek() {
//        // Arrange
//        StudentParam dto = new StudentParam();
//        dto.setIlecture(16L);
//       // dto.setIstudent(14L);
//        dto.setFinishedYn(1);
//
//        List<Integer> dayList = List.of(1, 2, 3); // 가상의 요일 리스트
//        when(mapper.selDayWeek(anyLong())).thenReturn(dayList);
//
//        when(mapper.insSdy(any())).thenReturn(1);
//
//        // Act
//        StudentInsRes res = service.insSdy(dto);
//
//        // Assert
//        assertNotNull(res);
////        assertEquals(dto.getIstudent(), res.getIstudent());
////        assertEquals(dto.getIlecture(), res.getIlecture());
//        assertEquals(dto.getFinishedYn(), res.getFinishedYn());
//
//        verify(mapper, times(1)).insSdy(any());
//    }
//
//
//}