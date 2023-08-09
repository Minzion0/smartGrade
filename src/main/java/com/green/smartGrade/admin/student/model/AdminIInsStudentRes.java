package com.green.smartGrade.admin.student.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AdminIInsStudentRes {
    private Long istudent;
    private String  studentNum;
    private Long imajor;
    private String nm;
    private String  gender;
    private LocalDate birthdate;
    private String phone;
    private int finishedYn;
    private LocalDateTime createdAt;
    private int grade;
    private int delYn;


    public AdminIInsStudentRes() {
    }

    public AdminIInsStudentRes(AdminInsStudentDto dto) {
        this.istudent=dto.getIstudent();
        this.studentNum=dto.getStudentNum();
        this.imajor = dto.getImajor();
        this.nm = dto.getNm();
        this.gender = dto.getGender();
        this.birthdate = dto.getBirthdate();
        this.phone = dto.getPhone();
        this.finishedYn = 1;
        this.createdAt = LocalDateTime.now();
        this.grade = 1;
        this.delYn=0;
    }
}
