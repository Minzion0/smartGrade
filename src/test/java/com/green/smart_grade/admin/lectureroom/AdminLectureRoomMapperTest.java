package com.green.smart_grade.admin.lectureroom;

import com.green.smart_grade.admin.lectureroom.model.LectureRoomInsDto;
import com.green.smart_grade.admin.lectureroom.model.LectureRoomInsParam;
import com.green.smart_grade.admin.lectureroom.model.LectureRoomRes;
import com.green.smart_grade.admin.lectureroom.model.LectureRoomVo;
import com.green.smart_grade.utils.PagingUtils;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AdminLectureRoomMapperTest {
    
    @Autowired
    private AdminLectureRoomMapper mapper;
    private PagingUtils utils;

    @Test
    void insLectureRoom() {
        //1차 테스트
        LectureRoomInsDto dto = new LectureRoomInsDto();
        dto.setLectureRoomName("505호");
        dto.setMaxCapacity(30);
        dto.setBuildingName("백매관");
        dto.setIlectureRoom(4L);

        int result = mapper.insLectureRoom(dto);
        assertEquals(1, result);


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