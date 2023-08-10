package com.green.smartGrade.student.model;

import lombok.Data;

@Data
public class StudentSelProfileDto {
    private Long istudent;
    private Long StudentNum;
    private int startIdx;
    private int page;
    private int row;
}
