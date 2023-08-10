//package com.green.smartGrade.admin.lectureroom;
//
//import com.green.smartGrade.admin.lectureroom.model.LectureRoomDelDto;
//import com.green.smartGrade.admin.lectureroom.model.LectureRoomDetailDto;
//import com.green.smartGrade.admin.lectureroom.model.LectureRoomInsDto;
//import com.green.smartGrade.admin.lectureroom.model.LectureRoomVo;
//import org.junit.jupiter.api.Test;
//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@MybatisTest
//@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class AdminLectureRoomMapperTest {
//
//    @Autowired
//    private AdminLectureRoomMapper mapper;
//
//    @Test
//    void insLectureRoom() {
//        LectureRoomInsDto dto = new LectureRoomInsDto();
//        dto.setLectureRoomName("503호");
//        dto.setBuildingName("문화관");
//        dto.setMaxCapacity(30);
//        int result = mapper.insLectureRoom(dto);
//
//        assertEquals(1, result);
//    }
//
//    @Test
//    void selLectureRoom() {
//        LectureRoomDetailDto dto = new LectureRoomDetailDto();
//        List<LectureRoomVo> list = mapper.selLectureRoom(dto);
//
//        String lectureRoomName = list.get(0).getLectureRoomName();
//        String buildingName = list.get(0).getBuildingName();
//        int maxCapacity = list.get(0).getMaxCapacity();
//
//        assertEquals("백매관", buildingName);
//        assertEquals("502호", lectureRoomName);
//        assertEquals(30, maxCapacity);
//
//        String lectureRoomName2 = list.get(1).getLectureRoomName();
//        String buildingName2 = list.get(1).getBuildingName();
//        int maxCapacity2 = list.get(1).getMaxCapacity();
//
//        assertEquals("백매관", buildingName2);
//        assertEquals("503호", lectureRoomName2);
//        assertEquals(30, maxCapacity2);
//    }
//
//    @Test
//    void delLectureRoom() {
//        LectureRoomDelDto dto = new LectureRoomDelDto();
//        LectureRoomDetailDto dto2 = new LectureRoomDetailDto();
//        dto.setIlectureRoom(1L);
//
//        int result = mapper.delLectureRoom(dto);
//        assertEquals(result, 1);
//
//        List<LectureRoomVo> list = mapper.selLectureRoom(dto2);
//        LectureRoomVo vo = list.get(0);
//
//        assertEquals(vo.getDelYn(), 1);
//    }
//}