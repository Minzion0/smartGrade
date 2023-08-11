package com.green.smartGrade.student.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class StudentSelProfile {
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
    private LocalDateTime createdAt;
    private int finishedYn;
    private int score;
    private String secretKey;
}
