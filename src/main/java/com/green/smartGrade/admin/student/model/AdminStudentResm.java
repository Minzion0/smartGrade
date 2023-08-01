package com.green.smartGrade.admin.student.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminStudentResm {
    private Long istudent;
    private String StudentNum;
    private String majorNm;
    private int grade;
    private String  nm;
    private String  gender;
    private String pic;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;
    private int finishedYn;
    private String  ilecture;
    private String lectureNm;
    private String lectureStrDate;
    private String lectureEndDate;
    private String lectureStrTime;
    private String lectureEndTime;
}
