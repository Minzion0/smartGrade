package com.green.smartGrade.admin.grade_mngmn;

import com.green.smartGrade.admin.grade_mngmn.model.*;
import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeUpdDto;
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

    int insGradeMngmn(GradeMngmnInsDto dto);

    int updAvgScore(GradeUpdDto dto);

    GradeAvgVo selAvgScore(GradeUpdDto dto);




}
