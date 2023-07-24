package com.green.smart_grade.admin.student.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminFindStudentRes {
    private Long istudent;
    private String studentNum;
    private int grade;
    private String nm;
    private String majoirName;
    private char gender;
    private LocalDate birthdate;
    private String phone;
    private LocalDate createdAt;
    private int finishedYn;
    private int score;
}
