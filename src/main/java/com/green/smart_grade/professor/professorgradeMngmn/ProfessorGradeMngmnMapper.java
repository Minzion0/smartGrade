package com.green.smart_grade.professor.professorgradeMngmn;

import com.green.smart_grade.professor.professorgradeMngmn.model.ProfessorGradeMngmnSelDto;
import com.green.smart_grade.professor.professorgradeMngmn.model.ProfessorGradeMngmnSelVo;
import com.green.smart_grade.professor.professorgradeMngmn.model.ProfessorGradeMngmnUpDto;

import com.green.smart_grade.professor.professorgradeMngmn.model.ProfessorGradeUpdDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfessorGradeMngmnMapper {

    int upMngnm(ProfessorGradeMngmnUpDto dto);
    List<ProfessorGradeMngmnSelVo> selStudentScore (ProfessorGradeMngmnSelDto dto);
    int selStudentScoreCount(ProfessorGradeMngmnSelDto dto);
    int updAvgScore(ProfessorGradeUpdDto dto);

    int getMaxAttendance(Long ilecture);
    int getMaxMidtermExamination(Long ilecture);
    int getMaxFinalExamination(Long ilecture);
}