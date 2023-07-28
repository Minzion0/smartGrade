package com.green.smart_grade.professor.professorgradeMngmn;

import com.green.smart_grade.professor.professorgradeMngmn.model.*;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfessorGradeMngmnMapper {

    int upMngnm(ProfessorGradeMngmnUpDto dto);
    List<ProfessorGradeMngmnSelVo> selStudentScore (ProfessorGradeMngmnSelDto dto);
    int selStudentScoreCount(ProfessorGradeMngmnSelDto dto);

    int getMaxAttendance(Long iprofessor);
    int getMaxMidtermExamination(Long iprofessor);
    int getMaxFinalExamination(Long iprofessor);

}
