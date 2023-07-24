package com.green.smart_grade.admin.student.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminInsStudentDto {
    private Long istudent;
    private String  studentNum;
    private String studentPassword;
    private Long imajor;
    private String nm;
    private char gender;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;
    private Long majorCnt;

    public AdminInsStudentDto(AdminInsStudentParam param) {
        this.imajor = param.getImajor();
        this.nm = param.getNm();
        this.gender = param.getGender();
        this.birthdate = param.getBirthdate();
        this.phone = param.getPhone();
        this.email = param.getEmail();
        this.address = param.getAddress();
    }
}
