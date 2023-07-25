package com.green.smart_grade.lecture_applly;

import com.green.smart_grade.lecture_applly.model.LectureAppllyInsDto;
import com.green.smart_grade.lecture_applly.model.LectureAppllyListOneDto;
import com.green.smart_grade.lecture_applly.model.LectureAppllyListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LectureAppllyMapper {
    int InsApplly(LectureAppllyInsDto dto);

    List<LectureAppllyListVo> selLectureApplly(LectureAppllyListOneDto dto);

}
