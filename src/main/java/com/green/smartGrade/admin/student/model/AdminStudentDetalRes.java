package com.green.smartGrade.admin.student.model;

import lombok.Data;

import java.util.List;

@Data
public class AdminStudentDetalRes {
    private AdminStudentDetalVo profile;
    private List<AdminStudentLectureDataRes> lectureList;
}
