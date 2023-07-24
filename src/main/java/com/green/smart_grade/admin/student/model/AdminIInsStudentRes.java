package com.green.smart_grade.admin.student.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AdminIInsStudentRes {
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
    private int finishedYn;
    private LocalDateTime createdAt;
    private int grade;
    private int delYn;

    public AdminIInsStudentRes() {
    }

    public AdminIInsStudentRes(AdminInsStudentDto dto) {
        this.istudent=dto.getIstudent();
        this.studentNum=dto.getStudentNum();
        this.studentPassword = dto.getStudentPassword();
        this.imajor = dto.getImajor();
        this.nm = dto.getNm();
        this.gender = dto.getGender();
        this.birthdate = dto.getBirthdate();
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.finishedYn = 1;
        this.createdAt = LocalDateTime.now();
        this.grade = 1;
        this.delYn=0;
    }
}
