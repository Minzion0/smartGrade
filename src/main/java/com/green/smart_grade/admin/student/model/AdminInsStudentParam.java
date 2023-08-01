package com.green.smart_grade.admin.student.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminInsStudentParam {

    private Long imajor;
    private String nm;
    private String  gender;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;

}
