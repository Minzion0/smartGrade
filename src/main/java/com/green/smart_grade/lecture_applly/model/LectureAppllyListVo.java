package com.green.smart_grade.lecture_applly.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class LectureAppllyListVo {
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
    private int garedLimit;
    private int delYn;
    private int opening_procedures;

}
