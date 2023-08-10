package com.green.smartGrade.admin.grade_mngmn;

import com.green.smartGrade.admin.grade_mngmn.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMngmnMapper {

    GradeMngmnDetailVo selGradeFindStudentDetail(GradeMngmnDetailSelDto dto);

    GradeMngmnDetailAvgVo selGradeFindStudentVo(GradeMngmnAvgDto dto);


    List<GradeMngmnVo> selGradeFindStudent(GradeMngmnAvgDto dto);

    List<GradeMngmnAvgVo> GradeMngmnAvg(GradeMngmnAvgDto dto);

    GradeMngmnStudentVo selGradeMngmnStudent(GradeMngmnAvgDto dto);

    int countGradeFindStudent();




}
