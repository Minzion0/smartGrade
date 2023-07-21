package com.green.smart_grade.lectureroom;

import com.green.smart_grade.lectureroom.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lectureroom")
@RequiredArgsConstructor
@Tag(name = "강의실")
public class LectureRoomController {

    @Autowired
    private final LectureRoomService SERVICE;

    @PostMapping
    @Operation(summary = "강의실 추가", description = "" +
            "lectureRoomName : 강의실 이름 \n" +
            "\n buildingName : 건물 이름 \n" +
            "\n maxCapacity : 최대 수용 인원 ")
    public LectureRoomRes insLectureRoom(@RequestBody LectureRoomInsParam param) {
        return SERVICE.insLectureRoom(param);
    }

    @GetMapping
    @Operation(summary = "강의실 리스트 전체 보기")
    public List<LectureRoomVo> getLectureRoom() {
        return SERVICE.selLectureRoom();
    }

    @PostMapping("/detail")
    @Operation(summary = "강의실 한개 보기 (삭제 안된것만 가능)")
    public LectureRoomDetailVo getLectureRoomDetail(@RequestBody LectureRoomDetailDto dto) {
        return SERVICE.selLectureRoomDetail(dto);
    }

    @DeleteMapping
    @Operation(summary = "강의실 삭제")
    public LectureRoomRes delLectureRoom(@RequestParam Long ilectureRoom, @RequestParam String lectureRoomName
                                , @RequestParam String buildingName) {
        LectureRoomDelParam p = new LectureRoomDelParam();
        p.setIlectureRoom(ilectureRoom);
        p.setBuildingName(buildingName);
        p.setLectureRoomName(lectureRoomName);
        return SERVICE.delLectureRoom(p);
    }
}
