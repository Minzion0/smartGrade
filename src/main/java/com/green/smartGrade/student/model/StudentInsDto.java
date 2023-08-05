package com.green.smartGrade.student.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentInsDto {
    private Long ilectureStudent;
    private Long istudent;
    private Long studentNum;
    private Long ilecture;
    private String dayWeek;
    private int finishedYn;
    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int totalScore;
    private LocalDate createdAt;
}
