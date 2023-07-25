package com.green.smart_grade.lecture_applly.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class LectureAppllyInsParam {
    private Long ilectureName;
    private Long ilectureRoom;
    private Long iprofessor;
    private Long isemester;
    private int openingProcedures;
    private LocalDate lectureStrDate;
    private LocalDate lectureEndDate;
    private String lectureStrTime;
    private String lectureEndTime;
    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int lectureMaxPeople;
    private int garedLimit;
    private int delYn;

}
