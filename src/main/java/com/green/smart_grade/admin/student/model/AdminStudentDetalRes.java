package com.green.smart_grade.admin.student.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AdminStudentDetalRes {
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

    private List<AdminStudentLectureDataRes>lectureList;


}
