package com.green.smartGrade.admin.lectureroom;

import com.green.smartGrade.admin.lectureroom.model.LectureRoomInsDto;
import com.green.smartGrade.admin.lectureroom.model.LectureRoomInsParam;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AdminLectureRoomMapperTest {

    @Autowired
    private AdminLectureRoomMapper mapper;

    @Test
    void insLectureRoom() {
        LectureRoomInsDto dto = new LectureRoomInsDto();
        dto.setLectureRoomName("502호");
        dto.setBuildingName("백매관");
        dto.setMaxCapacity(30);
        int result = mapper.insLectureRoom(dto);

        assertEquals(1, result);

    }

    @Test
    void selLectureRoom() {
    }

    @Test
    void delLectureRoom() {
    }
}