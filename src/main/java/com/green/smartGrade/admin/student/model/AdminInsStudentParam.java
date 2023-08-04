package com.green.smartGrade.admin.student.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminInsStudentParam {

    private Long imajor;
    private String nm;
    private String  gender;
    private LocalDate birthdate;
    private String phone;

}
