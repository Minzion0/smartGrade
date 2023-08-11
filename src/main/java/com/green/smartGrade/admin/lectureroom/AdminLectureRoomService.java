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
        dto.setStaIdx(utils.getStaIdx());

        List<LectureRoomVo> lectureRoom = MAPPER.selLectureRoom(dto);
        List<LectureRoomListVo> lectureRoomList = MAPPER.lectureRoomList(dto);
        return LectureRoomFindRes.builder()
                .lectureRoom(lectureRoom)
                .lectureRoomList(lectureRoomList)
                .page(utils)
                .build();
    }



    public LectureRoomDelRes delLectureRoom(LectureRoomDelParam p) throws Exception{
        LectureRoomDelDto dto = new LectureRoomDelDto();
        dto.setIlectureRoom(p.getIlectureRoom());
        int result = MAPPER.delLectureRoom(dto);
        if (result == 1) {
            return new LectureRoomDelRes(dto);
        }
        throw new Exception("삭제 안됨");
    }

}
