package com.green.smartGrade.admin.student;

import com.green.smartGrade.admin.student.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminStudentMapper {
    int insStudent(AdminInsStudentDto dto);

    AdminIInsStudentRes selStudent(String email);

    List<AdminFindStudentRes> findStudents(AdminFindStudentDto param);

    int countStudents(AdminFindStudentDto dto);

    AdminStudentDetalVo studentDt(Long istudent);

    List<AdminStudentLectureDataRes> studentLectures(Long istudent);

    int promotionGrade();


}
