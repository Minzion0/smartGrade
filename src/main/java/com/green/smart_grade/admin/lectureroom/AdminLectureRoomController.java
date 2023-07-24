package com.green.smart_grade.admin.lectureroom;

import com.green.smart_grade.admin.lectureroom.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lectureroom")
@RequiredArgsConstructor
@Tag(name = "강의실 관리")
public class AdminLectureRoomController {

    @Autowired
    private final AdminLectureRoomService SERVICE;

    @PostMapping
    @Operation(summary = "강의실 추가", description = "" +
            "lectureRoomName : 강의실 이름 \n" +
            "\n buildingName : 건물 이름 \n" +
            "\n maxCapacity : 최대 수용 인원 ")
    public LectureRoomRes insLectureRoom(@RequestBody LectureRoomInsParam param) {
        return SERVICE.insLectureRoom(param);
    }

    @GetMapping
    @Operation(summary = "강의실 리스트 전체 보기", description = "" +
            "ilectureRoom : 강의실 pk\n" +
            "\n lectureRoomName : 강의실 이름\n" +
            "\n buildingname : 건물 이름\n" +
            "\n maxCapacity : 최대 수용인원\n" +
            "\n del_yn : 삭제여부 ")
    public List<LectureRoomVo> getLectureRoom() {
        return SERVICE.selLectureRoom();
    }

    @PostMapping("/detail")
    @Operation(summary = "강의실 한개 보기 (삭제 안된것만 가능)",description = "" +
            "\nilectureRoom : 강의실 pk\n" +
            "\n lectureRoomName : 강의실 이름\n" +
            "\n buildingname : 건물 이름")
    public LectureRoomDetailVo getLectureRoomDetail(@RequestBody LectureRoomDetailDto dto) {
        return SERVICE.selLectureRoomDetail(dto);
    }

    @DeleteMapping
    @Operation(summary = "강의실 삭제 ( 삭제여부 0 1 변경 )", description = "" +
            "ilectureRoom : 강의실 pk \n" +
            "\n lectureRoomName : 강의실 호수 \n" +
            "\n buildingName : 건물 이름")
    public LectureRoomRes delLectureRoom(@RequestParam Long ilectureRoom, @RequestParam String lectureRoomName
                                , @RequestParam String buildingName) {
        LectureRoomDelParam p = new LectureRoomDelParam();
        p.setIlectureRoom(ilectureRoom);
        p.setBuildingName(buildingName);
        p.setLectureRoomName(lectureRoomName);
        return SERVICE.delLectureRoom(p);
    }
}
