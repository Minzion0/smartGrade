package com.green.smartGrade.admin.student.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminStudentDetalVo {
    private Long istudent;
    private String StudentNum;
    private Long imajor;
    private int grade;
    private String  name;
    private String  gender;
    private String pic;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;
    private int finishedYn;
    private int score;

}
