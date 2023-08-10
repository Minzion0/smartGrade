package com.green.smartGrade.student.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentMajor {
    private Long ilectureStuden;
    private Long istudent;
    private Long ilecture;
    private Long ilectureName;
    private int finishedYn;
    private int dayWeek;
    private int openingProcedures;
    private LocalDate lectureStrDate;
    private LocalDate lectureEndDate;
    private String lectureStrTime;
    private String lectureEndTime;
    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int score;

}
