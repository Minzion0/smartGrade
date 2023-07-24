package com.green.smart_grade.admin.professor;

import com.green.smart_grade.admin.professor.model.AdminFindProfessorRes;
import com.green.smart_grade.admin.professor.model.AdminInsProfessorDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminProfessorMapper {
    int insProfessor(AdminInsProfessorDto dto);
    int countProfessor();
    List<AdminFindProfessorRes> findProfessors(int staIdx, String name);
}
