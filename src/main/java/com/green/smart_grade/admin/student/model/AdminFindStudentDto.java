package com.green.smart_grade.admin.student.model;

import lombok.Data;

@Data
public class AdminFindStudentDto {
    private String studentNum;
    private String nm;
    private int staIdx;
    private int row;
    private int grade;
}
