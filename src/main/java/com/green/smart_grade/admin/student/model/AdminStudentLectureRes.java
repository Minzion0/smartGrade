package com.green.smart_grade.admin.student.model;

import lombok.Data;

import java.util.List;

@Data
public class AdminStudentLectureRes {
    private Long istudent;
    private String studentNum;
    private String majorName;
    private int grade;
    private String  nm;

    private List<AdminStudentLectureDataRes>list;


    public AdminStudentLectureRes(AdminStudentDetalRes res) {
        this.istudent = res.getIstudent();
        this.studentNum = res.getStudentNum();
        this.majorName = res.getMajorNm();
        this.grade = res.getGrade();
        this.nm = res.getNm();
    }
}
