package com.green.smartGrade.professor;

import com.green.smartGrade.professor.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfessorMapper {


    List<ProfessorVo> selProfessor(ProfessorSelDto dto); //  페이지 로우 교수 리스트
    int ProfessorCount();

    int upProfessorPw(ProfessorUpPW dto);

    int upProfessor(ProfessorUpDto dto);

    List<ProfessorVo> selAllProfessor(ProfessorSelDto dto); // 교수 리스트 전체 뽑기

    int upPicProfessor(ProfessorPicDto dto);
    List<ProfessorSelLectureVo> selProfessorLecture(ProfessorSelLectureDto dto);
    List<ProfessorSelLectureVo> selProfessorLectureALl(ProfessorSelLectureDto dto);
    int selProfessorLectureCount(ProfessorSelLectureDto dto);



}
