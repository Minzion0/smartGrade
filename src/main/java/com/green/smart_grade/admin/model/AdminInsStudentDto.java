package com.green.smart_grade.admin.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminInsStudentDto {
    private Long istudent;
    private String password;
    private Long imajor;
    private String name;
    private char gender;
    private String birthdate;
    private String phone;
    private String email;
    private String address;

}
