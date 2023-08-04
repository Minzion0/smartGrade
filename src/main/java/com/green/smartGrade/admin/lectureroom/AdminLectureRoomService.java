package com.green.smartGrade.admin.lectureroom;

import com.green.smartGrade.admin.lectureroom.model.*;

import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminLectureRoomService {

    @Autowired
    private final AdminLectureRoomMapper MAPPER;

    public LectureRoomRes insLectureRoom(LectureRoomInsParam p) {
        LectureRoomInsDto dto = new LectureRoomInsDto();
        dto.setLectureRoomName(p.getLectureRoomName());
        dto.setBuildingName(p.getBuildingName());
        dto.setMaxCapacity(p.getMaxCapacity());
        int result = MAPPER.insLectureRoom(dto);
        if (result == 1) {
           return new LectureRoomRes(dto);
        }
        return null;
    }

    public LectureRoomFindRes selLectureRoom(LectureRoomDetailDto dto) {
        int maxPage = MAPPER.countLectureRoom();
        PagingUtils utils = new PagingUtils(dto.getPage(),maxPage);

        List<LectureRoomVo> lectureRoom = MAPPER.selLectureRoom(dto);
        return LectureRoomFindRes.builder()
                .lectureRoom(lectureRoom)
                .page(utils)
                .build();
    }



    public LectureRoomRes delLectureRoom(LectureRoomDelParam p) {
        LectureRoomDelDto dto = new LectureRoomDelDto();
        dto.setBuildingName(p.getBuildingName());
        int result = MAPPER.delLectureRoom(dto);
        if (result == 1) {
            new LectureRoomRes(dto);
        }
        return null;
    }

}
