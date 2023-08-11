package com.green.smartGrade.admin.grade_mngmn.model;

import lombok.Data;

@Data
public class GradeMngmnAvgDto {
    private Long istudent;
    private String studentNum;
    private String name;
    private int semester;
    private int grade;
    private int totalScore;
    private String rating;
    private int page;
    private int staIdx;

}
