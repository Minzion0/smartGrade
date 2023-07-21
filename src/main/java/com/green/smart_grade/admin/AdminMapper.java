package com.green.smart_grade.admin;

import com.green.smart_grade.admin.model.AdminIInsStudentRes;
import com.green.smart_grade.admin.model.AdminInsStudentDto;
import com.green.smart_grade.admin.model.AdminInsStudentParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    int insStudent(AdminInsStudentDto dto);
    AdminIInsStudentRes selStudent(String email);
}
