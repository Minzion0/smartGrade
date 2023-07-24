package com.green.smart_grade.admin.model;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AdminSelLectureRes {
    private Long ilecture;
    private String lectureNm;
    private Long isemester;
    private String nm;
    private String lectureRoomNm;
    private String buildingNm;
    private LocalDate strDate;
    private LocalDate endDate;
    private LocalTime strTime;
    private LocalTime endTime;
    private int maxPeople;
    private int procedures;
    private int delYn;
}
