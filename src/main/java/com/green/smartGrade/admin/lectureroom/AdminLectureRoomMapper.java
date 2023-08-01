package com.green.smartGrade.admin.lectureroom;

import com.green.smartGrade.admin.lectureroom.model.*;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminLectureRoomMapper {
    int insLectureRoom(LectureRoomInsDto dto);

    List<LectureRoomVo> selLectureRoom(int staIdx);

    int delLectureRoom(LectureRoomDelDto dto);

    int countLectureRoom();

}
