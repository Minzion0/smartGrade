package com.green.smartGrade.lecture_applly;

import com.green.smartGrade.lecture_applly.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LectureAppllyMapper {
    int InsApplly(LectureAppllyInsDto dto);

    List<LectureAppllySelOneRes> selLectureApplly(LectureApllyT t);

    int InsDayWeek(List<LectureApllyDto> dto);

    int selAplly();

}
