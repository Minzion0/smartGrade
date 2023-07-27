package com.green.smart_grade.professor.professorgradeMngmn;

import com.green.smart_grade.professor.professorgradeMngmn.model.ProfessorGradeMngmnSelDto;
import com.green.smart_grade.professor.professorgradeMngmn.model.ProfessorGradeMngmnSelVo;
import com.green.smart_grade.professor.professorgradeMngmn.model.ProfessorGradeMngmnUpDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfessorGradeMngmnMapper {

    int upMngnm(ProfessorGradeMngmnUpDto dto);
    List<ProfessorGradeMngmnSelVo> selStudentScore (ProfessorGradeMngmnSelDto dto);
    int selStudentScoreCount(ProfessorGradeMngmnSelDto dto);
}
