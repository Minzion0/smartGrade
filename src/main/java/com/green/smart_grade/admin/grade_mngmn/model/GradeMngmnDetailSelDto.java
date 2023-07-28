package com.green.smart_grade.admin.grade_mngmn.model;

import lombok.Data;

@Data
public class GradeMngmnDetailSelDto {
    private int totalScore;
    private int score;
    private int istudent;
    private String studentNum;
    private String name;
    private String rating;
}
