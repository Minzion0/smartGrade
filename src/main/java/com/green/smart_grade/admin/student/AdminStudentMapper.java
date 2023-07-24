package com.green.smart_grade.admin.student;

import com.green.smart_grade.admin.student.model.AdminFindStudentDto;
import com.green.smart_grade.admin.student.model.AdminFindStudentRes;
import com.green.smart_grade.admin.student.model.AdminIInsStudentRes;
import com.green.smart_grade.admin.student.model.AdminInsStudentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminStudentMapper {
    int insStudent(AdminInsStudentDto dto);
    AdminIInsStudentRes selStudent(String email);
    List<AdminFindStudentRes> findStudents(AdminFindStudentDto param);
    int countStudents();
}
