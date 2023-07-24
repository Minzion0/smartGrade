package com.green.smart_grade.lecture_applly;

import com.green.smart_grade.lecture_applly.model.LectureAppllyInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureAppllyMapper {
    int InsApplly(LectureAppllyInsDto dto);
}
