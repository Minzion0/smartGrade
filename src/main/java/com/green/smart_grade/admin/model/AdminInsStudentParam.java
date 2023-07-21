package com.green.smart_grade.admin.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminInsStudentParam {

    private Long imajor;
    private String nm;
    private char gender;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;

}
