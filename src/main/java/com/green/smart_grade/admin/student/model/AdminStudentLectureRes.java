package com.green.smart_grade.admin.student.model;

import lombok.Data;

import java.util.List;

@Data
public class AdminStudentLectureRes {
    private int istudent;
    private String studentNum;
    private String majorName;
    private int grade;
    private String  nm;

    private List<AdminStudentLectureDataRes>list;


    public AdminStudentLectureRes(AdminStudentDetalRes res) {
        this.istudent = res.getIstudent();
        this.studentNum = res.getStudentNum();
        this.majorName = res.getMajorName();
        this.grade = res.getGrade();
        this.nm = res.getNm();
    }
}
