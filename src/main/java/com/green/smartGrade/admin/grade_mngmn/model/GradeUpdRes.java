package com.green.smartGrade.admin.grade_mngmn.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GradeUpdRes {
    private int totalScore;
    private int avgScore;
    private double rating;
    private Long istudent;
    private int semester;
}
