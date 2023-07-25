package com.green.smart_grade.admin.grade_mngmn.model;

import lombok.Data;

@Data
public class GradeMngmnUpdDto {
    private Long istudent;
    private Long isemester;
    private double rating;
    private int totalScore;
}
