package com.green.smart_grade.lectureroom;

import com.green.smart_grade.lectureroom.model.*;
import com.green.smart_grade.major.model.MajorRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureRoomService {

    @Autowired
    private final LectureRoomMapper MAPPER;

    public LectureRoomRes insLectureRoom(LectureRoomInsParam p) {
        LectureRoomInsDto dto = new LectureRoomInsDto();
        dto.setLectureRoomName(p.getLectureRoomName());
        dto.setBuildingName(p.getBuildingName());
        dto.setMaxCapacity(p.getMaxCapacity());
        int result = MAPPER.insLectureRoom(dto);
        if (result == 1) {
            new LectureRoomRes(dto);
        }
        return null;
    }

    public List<LectureRoomVo> selLectureRoom() {
        return MAPPER.selLectureRoom();
    }

    public LectureRoomDetailVo selLectureRoomDetail(LectureRoomDetailDto dto) {
        return MAPPER.selLectureRoomDetail(dto);
    }

    public LectureRoomRes delLectureRoom(LectureRoomDelParam p) {
        LectureRoomDelDto dto = new LectureRoomDelDto();
        dto.setIlectureRoom(p.getIlectureRoom());
        dto.setLectureRoomName(p.getLectureRoomName());
        dto.setBuildingName(p.getBuildingName());
        int result = MAPPER.delLectureRoom(dto);
        if (result == 1) {
            new LectureRoomRes(dto);
        }
        return null;
    }

}
