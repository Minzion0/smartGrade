package com.green.smart_grade.grade_mngmn.model;

import lombok.Data;

@Data
public class GradeMngmnDetailVo {
    private int grade;
    private int semester;
    private int score;
    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int totalScore;
}
