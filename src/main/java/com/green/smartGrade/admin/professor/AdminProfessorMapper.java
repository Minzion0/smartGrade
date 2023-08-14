package com.green.smartGrade.admin.professor;

import com.green.smartGrade.admin.professor.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminProfessorMapper {
    int insProfessor(AdminInsProfessorDto dto);

    int countProfessor(AdminFindProfessorDto dto);

    List<AdminFindProfessorRes> findProfessors(AdminFindProfessorDto dto);



    AdminProfessorDetailProfile professorProfile(AdminProfessorDetailDto dto);

    List<AdminProfessorMajor> professorMajor(AdminProfessorDetailDto dto);

}
