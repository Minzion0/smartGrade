package com.green.smart_grade.admin.student.model;

import lombok.Data;

@Data
public class AdminStudentDetalRes {
    private int istudent;
    private String StudentNum;
    private String majorName;
    private int grade;
    private String  nm;
    private String ilecture;
    private String lectureName;
    private String attendance;
    private String midtermEx;
    private String finalEx;
    private String totalScore;
}
