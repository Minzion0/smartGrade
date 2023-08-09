package com.green.smartGrade.professor;

import com.green.smartGrade.professor.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfessorMapper {


    List<ProfessorVo> selProfessor(ProfessorSelDto dto); //  페이지 로우 교수 리스트
    int ProfessorCount();

    int upProfessor(ProfessorUpDto dto);


    List<ProfessorSelLectureVo> selProfessorLecture(ProfessorSelLectureDto dto);
    List<ProfessorSelLectureVo> selProfessorLectureALl(ProfessorSelLectureDto dto);
    int selProfessorLectureCount(ProfessorSelLectureDto dto);

    int updPassword(ProfessorUpdPasswordDto dto);


    String picFilePathByProfessor(Long iprofessor);
    void updateFilePathNullByProfessor(Long iprofessor);

    ProfessorSelCurrentPasswordVo selPasswordCurrent (ProfessorSelCurrentPasswordDto dto);


}
