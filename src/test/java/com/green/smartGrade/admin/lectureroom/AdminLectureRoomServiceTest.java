//package com.green.smartGrade.admin.lectureroom;
//
//import com.green.smartGrade.admin.lectureroom.model.*;
//import lombok.Builder;
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
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//@Import({AdminLectureRoomService.class})
//class AdminLectureRoomServiceTest {
//
//    @MockBean
//    private AdminLectureRoomMapper mapper;
//
//    @Autowired
//    private AdminLectureRoomService service;
//
//    @Test
//    void insLectureRoom() {
//        LectureRoomInsParam p = new LectureRoomInsParam();
//        p.setLectureRoomName("510호");
//        p.setBuildingName("백매관");
//        p.setMaxCapacity(30);
//
//        when(mapper.insLectureRoom(any())).thenReturn(1);
//
//        LectureRoomRes res1 = service.insLectureRoom(p);
//
//        assertEquals(p.getLectureRoomName(), res1.getLectureRoomName());
//        assertEquals(p.getMaxCapacity(), res1.getMaxCapacity());
//        assertEquals(p.getBuildingName(), res1.getBuildingName());
//
//        verify(mapper).insLectureRoom(any());
//    }
//
//    @Test
//    void selLectureRoom() {
//        LectureRoomDetailDto dto = new LectureRoomDetailDto();
//        List<LectureRoomVo> voList = new ArrayList<>();
//        voList.add(new LectureRoomVo(1L, "502호", "백매관", 30, 0));
//
//        when(mapper.selLectureRoom(any())).thenReturn(voList);
//
//        LectureRoomFindRes res = service.selLectureRoom(dto);
//
//
//        assertEquals(voList.get(0).getLectureRoomName(), res.getLectureRoom().get(0).getLectureRoomName());
//        assertEquals(voList.get(0).getBuildingName(), res.getLectureRoom().get(0).getBuildingName());
//        assertEquals(voList.get(0).getIlectureRoom(), res.getLectureRoom().get(0).getIlectureRoom());
//
//        verify(mapper).selLectureRoom(any());
//    }
//
//    @Test
//    void delLectureRoom() {
//        LectureRoomDelParam p = new LectureRoomDelParam();
//
//        p.setIlectureRoom(1L);
//        p.setLectureRoomName("502호");
//        p.setBuildingName("백매관");
//
//        when(mapper.delLectureRoom(any())).thenReturn(1);
//
//        LectureRoomDelRes res = service.delLectureRoom(p);
//
//        assertEquals(res.getIlectureRoom(), p.getIlectureRoom());
//
//        verify(mapper).delLectureRoom(any());
//    }
//}