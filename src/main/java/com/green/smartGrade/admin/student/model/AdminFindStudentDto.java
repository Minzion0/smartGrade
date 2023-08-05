package com.green.smartGrade.admin.student.model;

import lombok.Data;

@Data
public class AdminFindStudentDto {
    private Long imajor;
    private String studentNum;
    private String nm;
    private int finishedYn;
    private int staIdx;
    private int row;
    private int grade;
}
