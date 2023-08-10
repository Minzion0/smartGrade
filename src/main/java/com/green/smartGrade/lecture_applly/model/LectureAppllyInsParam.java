package com.green.smartGrade.lecture_applly.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LectureAppllyInsParam {
    private Long ilectureName;
    private Long ilectureRoom;
    private Long isemester;
    private int openingProcedures;
    private LocalDate lectureStrDate;
    private LocalDate lectureEndDate;
    private String lectureStrTime;
    private String lectureEndTime;
    private String dayWeek;
    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int lectureMaxPeople;
    private int garedLimit;
    private int delYn;

}
