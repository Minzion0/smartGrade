package com.green.smartGrade.admin.model;

import lombok.Data;

@Data
public class AdminLectureInStudentRes {
    private Long istudent;
    private String nm;
    private String majorNm;
    private int attendance;
    private int minEx;
    private int finEx;
    private int totalScore;
    private double avg;
    private String gread;
}
