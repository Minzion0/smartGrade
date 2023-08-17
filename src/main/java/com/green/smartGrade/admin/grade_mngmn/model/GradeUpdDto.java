package com.green.smartGrade.admin.grade_mngmn.model;

import lombok.Data;

@Data
public class GradeUpdDto {
    private Long istudent;
    private int semester;
    private double rating;
}
