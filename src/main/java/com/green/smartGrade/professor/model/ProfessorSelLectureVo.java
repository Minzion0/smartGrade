package com.green.smartGrade.professor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfessorSelLectureVo {
    private String lectureStrDate;
    private String lectureEndDate;
    private String lectureStrTime;
    private String lectureEndTime;
    private int openingProcedures;
    private int gradeLimit;
    private String lectureName;
    private int score;
    private String lectureRoomName;
    private int maxCapacity;
    private String dayWeek;
    private int semester;
}
