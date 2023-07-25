package com.green.smart_grade.admin.grade_mngmn;

import com.green.smart_grade.admin.grade_mngmn.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMngmnMapper {
    List<GradeMngmnVo> selGradeFindStudent(GradeMngmnSelDto dto);

    GradeMngmnDetailVo selGradeFindStudentDetail(GradeMngmnDetailSelDto dto);

    int countGradeFindStudent();

    int updRating(GradeMngmnUpdDto dto);
}
