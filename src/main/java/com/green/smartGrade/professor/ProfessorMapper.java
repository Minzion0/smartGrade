package com.green.smartGrade.professor;

import com.green.smartGrade.professor.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfessorMapper {





    int upProfessor(ProfessorUpDto dto);


    List<ProfessorSelLectureVo> selProfessorLecture(ProfessorSelLectureDto dto);

    int selProfessorLectureCount(ProfessorSelLectureDto dto);

    int updPassword(ProfessorUpdPasswordDto dto);



    String picFilePathByProfessor(Long iprofessor);
    void updateFilePathNullByProfessor(Long iprofessor);

    ProfessorSelCurrentPasswordVo selPasswordCurrent (ProfessorSelCurrentPasswordDto dto);

    ProfessorDatilProfile selProfessor(ProfessorSelDto dto);

    List<ProfessorMajor> professorMajor(ProfessorSelDto dto);


    ProfessorUpDto getProfessorById(Long iprofessor);
}
