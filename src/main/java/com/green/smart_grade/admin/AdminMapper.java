package com.green.smart_grade.admin;

import com.green.smart_grade.admin.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    int insStudent(AdminInsStudentDto dto);
    AdminIInsStudentRes selStudent(String email);
    List<AdminFindStudentRes> findStudents(AdminFindStudentDto param);

    int insProfessor(AdminInsProfessorDto dto);
    int countProfessor();
    List<AdminFindProfessorRes>findProfessors(int staIdx);
}
