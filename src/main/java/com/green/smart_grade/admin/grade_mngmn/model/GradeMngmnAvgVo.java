package com.green.smart_grade.admin.grade_mngmn.model;

import lombok.Data;

@Data
public class GradeMngmnAvgVo {
    private int grade;
    private Long isemester;
    private Long ilecture;
    private String studentNum;
    private int avgScore;
    private double rating;
}
