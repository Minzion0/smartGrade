package com.green.smartGrade.admin.student.model;

import lombok.Data;

import java.util.List;

@Data
public class AdminStudentLectureRes {
    private Long istudent;
    private String studentNum;
    private Long imajor;
    private int grade;
    private String  name;

    private List<AdminStudentLectureDataRes>list;


    public AdminStudentLectureRes(AdminStudentDetalVo res) {
        this.istudent = res.getIstudent();
        this.studentNum = res.getStudentNum();
        this.imajor = res.getImajor();
        this.grade = res.getGrade();
        this.name = res.getName();
    }
}
