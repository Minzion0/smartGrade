package com.green.smart_grade.lecture_applly.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LectureAppllyEntity {
    private Long ilecture;
    private Long ilectureName;
    private Long ilectureRoom;
    private Long iprofessor;
    private Long isemester;
    private int openingProcedures;
    private LocalDate lectureStrDate;
    private LocalDate lectureEndDate;
    private LocalDate lectureStrTime;
    private LocalDate lectureEndTime;
    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int lectureMaxPeople;
    private int garedLimit;
    private int delYn;

}
