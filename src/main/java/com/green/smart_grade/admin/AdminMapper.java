package com.green.smart_grade.admin;

import com.green.smart_grade.admin.model.*;
import com.green.smart_grade.admin.student.model.AdminFindStudentDto;
import com.green.smart_grade.admin.student.model.AdminFindStudentRes;
import com.green.smart_grade.admin.student.model.AdminIInsStudentRes;
import com.green.smart_grade.admin.student.model.AdminInsStudentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    int insProfessor(AdminInsProfessorDto dto);
    int countProfessor();
    List<AdminFindProfessorRes>findProfessors(int staIdx,String name);
}
