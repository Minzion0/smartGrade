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
@Tag(name = "관리자 강의실 관리")
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
    @Operation(summary = "강의실 리스트 전체 보기 (검색기능 추가 필요)", description = "" +
            "ilectureRoom : 강의실 pk\n" +
            "\n lectureRoomName : 강의실 이름\n" +
            "\n buildingname : 건물 이름\n" +
            "\n maxCapacity : 최대 수용인원\n" +
            "\n del_yn : 삭제여부 ")
    public LectureRoomFindRes getLectureRoom(@RequestParam (defaultValue = ("1")) int page,
                                             @RequestParam (required = false) String buildingName,
                                             @RequestParam (required = false) String lectureRoomName) {
        LectureRoomDetailDto dto = new LectureRoomDetailDto();
        dto.setLectureRoomName(lectureRoomName);
        dto.setBuildingName(buildingName);
        return SERVICE.selLectureRoom(page);
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
