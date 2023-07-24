package com.green.smart_grade.admin.lectureroom;

import com.green.smart_grade.admin.lectureroom.model.*;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LectureRoomMapper {
    int insLectureRoom(LectureRoomInsDto dto);

    List<LectureRoomVo> selLectureRoom();

    LectureRoomDetailVo selLectureRoomDetail(LectureRoomDetailDto dto);

    int delLectureRoom(LectureRoomDelDto dto);

}
