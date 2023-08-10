package com.green.smartGrade.student.model;

import lombok.Data;

@Data
public class StudentSelDto {
    private  Long istudent;
    protected Long studentNum;
    private int startIdx;
    private int page;
    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int totalScore;
    private double point;
    private String rating;
    private Long ilecture;
    private int row;
}
