package com.green.smart_grade.admin.student;

import com.green.smart_grade.admin.student.model.*;
import com.green.smart_grade.utils.PagingUtils;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminStudentMapper {
    int insStudent(AdminInsStudentDto dto);
    AdminIInsStudentRes selStudent(String email);
    List<AdminFindStudentRes> findStudents(AdminFindStudentDto param);
    int countStudents(AdminFindStudentDto dto);
    AdminStudentDetalRes studentDt(Long istudent);
    List<AdminStudentLectureDataRes> studentLectures(Long istudent);
}
