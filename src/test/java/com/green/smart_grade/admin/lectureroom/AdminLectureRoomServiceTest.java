package com.green.smart_grade.admin.lectureroom;

import com.green.smart_grade.admin.lectureroom.model.LectureRoomInsDto;
import com.green.smart_grade.admin.lectureroom.model.LectureRoomInsParam;
import com.green.smart_grade.admin.lectureroom.model.LectureRoomRes;
import com.green.smart_grade.lecture.LectureMapper;
import org.apache.ibatis.annotations.Many;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import({AdminLectureRoomService.class})
class AdminLectureRoomServiceTest {

    @MockBean
    private AdminLectureRoomMapper mapper;

    @Autowired
    private AdminLectureRoomService service;

    @Test
    void insLectureRoom() {
        when(mapper.insLectureRoom(any())).thenReturn(4);

        LectureRoomInsParam p1 = new LectureRoomInsParam();
        p1.setLectureRoomName("507호");
        p1.setBuildingName("백매관");
        p1.setMaxCapacity(30);

        LectureRoomRes r1 = service.insLectureRoom(p1);

        assertEquals(p1.getLectureRoomName(), r1.getLectureRoomName());

        verify(mapper).insLectureRoom(any());

    }

    @Test
    void selLectureRoom() {
    }

    @Test
    void selLectureRoomFind() {
    }

    @Test
    void delLectureRoom() {
    }
}