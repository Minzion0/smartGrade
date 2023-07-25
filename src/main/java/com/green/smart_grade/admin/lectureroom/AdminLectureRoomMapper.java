package com.green.smart_grade.admin.lectureroom;

import com.green.smart_grade.admin.lectureroom.model.*;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminLectureRoomMapper {
    int insLectureRoom(LectureRoomInsDto dto);

    List<LectureRoomVo> selLectureRoom(int staIdx);

    List<LectureRoomDetailVo> selLectureRoomFind(LectureRoomDetailDto dto);

    int delLectureRoom(LectureRoomDelDto dto);

    int countLectureRoom();

}
