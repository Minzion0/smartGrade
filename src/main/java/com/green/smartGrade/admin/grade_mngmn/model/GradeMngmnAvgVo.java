package com.green.smartGrade.admin.grade_mngmn.model;

import lombok.Data;

@Data
public class GradeMngmnAvgVo {
    private int grade;
    private int semester;
    private int avgScore;
    private double avgRating;
}
