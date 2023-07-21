package com.green.smart_grade.lectureroom;

import com.green.smart_grade.lectureroom.model.LectureRoomDetailDto;
import com.green.smart_grade.lectureroom.model.LectureRoomDetailVo;
import com.green.smart_grade.lectureroom.model.LectureRoomInsDto;
import com.green.smart_grade.lectureroom.model.LectureRoomVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LectureRoomMapper {
    int insLectureRoom(LectureRoomInsDto dto);

    List<LectureRoomVo> selLectureRoom();

    LectureRoomDetailVo selLectureRoomDetail(LectureRoomDetailDto dto);

}
