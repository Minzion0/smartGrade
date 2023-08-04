package com.green.smartGrade.lecture_applly.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LectureAppllySelOneRes {
    private Long ilecture;
    private Long ilectureName;
    private Long ilectureRoom;
    private Long iprofessor;
    private Long isemester;
    private LocalDate lectureStrDate;
    private LocalDate lectureEndDate;
    private String lectureStrTime;
    private String lectureEndTime;
    private int lectureMaxPeople;
    private int gradeLimit;
    private int delYn;
    private int openingProcedures;
}
