package com.green.smart_grade.professor;

import com.green.smart_grade.professor.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfessorMapper {
    int insProfessor(ProfessorInsDto dto); // 교수 프로필

    List<ProfessorVo> selProfessor(ProfessorSelDto dto); // 교수 리스트

    int upProfessorPw(ProfessorUpPW dto);

    ProfessorLoginVo selProfessorByUid(ProfessorLoginDto dto);

    int upProfessor(ProfessorUpDto dto);
}
