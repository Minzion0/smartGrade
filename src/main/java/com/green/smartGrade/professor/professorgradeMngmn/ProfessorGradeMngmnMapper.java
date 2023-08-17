package com.green.smartGrade.professor.professorgradeMngmn;

import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeMngmnSelDto;
import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeMngmnSelVo;
import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeMngmnUpDto;

import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeUpdDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfessorGradeMngmnMapper {

    int upMngnm(ProfessorGradeMngmnUpDto dto);
    List<ProfessorGradeMngmnSelVo> selStudentScore (ProfessorGradeMngmnSelDto dto);
    int selStudentScoreCount(ProfessorGradeMngmnSelDto dto);


    int getMaxAttendance(Long ilecture);
    int getMaxMidtermExamination(Long ilecture);
    int getMaxFinalExamination(Long ilecture);
}
