package com.green.smartGrade.admin.grade_mngmn.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GradeMngmnVo {
    private int grade;
    private int semester;
    private String lectureName;
    private String professorName;
    private int lectureScore;
    private int totalScore;
    private String rating;
}
