package com.green.smartGrade.student.model;

import lombok.Data;

@Data
public class StudentSelPointVo {
    private Long istudent;
    private Long StudentNum;
    private Long imajor;
    private int grade;
    private int finishedYn;
    private int score;
    private int graduationScore;
    private int remainingPoints;
}
