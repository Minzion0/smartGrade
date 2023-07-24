package com.green.smart_grade.admin.grade_mngmn.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GradeMngmnVo {
    private Long istudent;
    private Long ilecture;
    private Long imajor;
    private int studentNum;
    private String name;
    private char gender;
    private LocalDate birthDate;
    private int score;
}
