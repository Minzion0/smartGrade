package com.green.smartGrade.admin.model;

import lombok.Data;

import java.time.LocalDate;

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
    private String  strTime;
    private String  endTime;
    private int maxPeople;
    private int currentPeople;
    private int procedures;
    private int delYn;
}
