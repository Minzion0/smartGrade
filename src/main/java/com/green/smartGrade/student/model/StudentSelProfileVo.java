package com.green.smartGrade.student.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentSelProfileVo {
    private Long istudent;
    private Long StudentNum;
    private Long imajor;
    private int grade;
    private String nm;
    private String pic;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;
    private int finishedYn;
    private int score;

}
