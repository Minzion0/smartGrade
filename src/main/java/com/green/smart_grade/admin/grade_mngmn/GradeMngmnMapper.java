package com.green.smart_grade.admin.grade_mngmn;

import com.green.smart_grade.admin.grade_mngmn.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMngmnMapper {

    GradeMngmnDetailVo selGradeFindStudentDetail(GradeMngmnDetailSelDto dto);

    List<GradeMngmnVo> selGradeFindStudent(GradeMngmnAvgDto dto);

    GradeMngmnAvgVo GradeMngmnAvg(GradeMngmnAvgDto dto);

    GradeMngmnDetailAvgVo selGradeFindStudentVo(GradeMngmnAvgDto dto);

    int countGradeFindStudent();



}