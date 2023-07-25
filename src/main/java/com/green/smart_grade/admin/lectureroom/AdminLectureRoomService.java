package com.green.smart_grade.admin.lectureroom;

import com.green.smart_grade.admin.lectureroom.model.*;

import com.green.smart_grade.utils.PagingUtils;
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
            new LectureRoomRes(dto);
        }
        return null;
    }

    public LectureRoomFindRes selLectureRoom(int page) {
        int maxPage = MAPPER.countLectureRoom();
        PagingUtils utils = new PagingUtils(page,maxPage);

        List<LectureRoomVo> lectureRoom = MAPPER.selLectureRoom(utils.getStaIdx());
        return LectureRoomFindRes.builder()
                .lectureRoom(lectureRoom)
                .page(utils)
                .build();
    }

    public List<LectureRoomDetailVo> selLectureRoomFind(LectureRoomDetailDto dto) {
        return MAPPER.selLectureRoomFind(dto);
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
