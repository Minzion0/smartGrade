package com.green.smartGrade.student.model;

import lombok.Data;

@Data
public class StudentSelPointDto {
    private Long istudent;
    private Long studentNum;
    private int startIdx;
    private int page;
    private int row;
}
