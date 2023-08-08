package com.green.smartGrade.student.model;

import lombok.Data;

@Data
public class StudentSelVo {
    private Long istudent;
    protected Long studentNum;
    private Long ilectureName;
    private String lectureName;
    private Long iprofessor;
    private int score;
    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int totalScore;
    private String grade;
    private String rating;
    private int finishedYn;
}
