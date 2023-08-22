package com.green.smartGrade.admin.grade_mngmn.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GradeUpdRes {
    private Long istudent;
    private int grade;
    private int semester;
    private int avgScore;
    private double avgRating;
}
