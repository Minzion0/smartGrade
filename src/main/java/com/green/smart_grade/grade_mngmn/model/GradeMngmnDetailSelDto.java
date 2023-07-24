package com.green.smart_grade.grade_mngmn.model;

import lombok.Data;

@Data
public class GradeMngmnDetailSelDto {
    private int totalScore;
    private int score;
    private int studentNum;
    private String name;
    private String rating;
}
