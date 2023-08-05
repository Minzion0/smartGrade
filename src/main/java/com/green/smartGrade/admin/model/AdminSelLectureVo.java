package com.green.smartGrade.admin.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminSelLectureVo {
    private Long ilecture;
    private String lectureNm;
    private int semester;
    private String nm;
    private String lectureRoomNm;
    private String buildingNm;
    private LocalDate strDate;
    private LocalDate endDate;
    private String  strTime;
    private String  endTime;
    private int maxPeople;
    private int procedures;
    private int delYn;

    public AdminSelLectureVo(AdminSelLectureRes re) {
        this.ilecture = re.getIlecture();
        this.lectureNm = re.getLectureNm();
        this.semester = re.getSemester();
        this.nm = re.getNm();
        this.lectureRoomNm = re.getLectureRoomNm();
        this.buildingNm = re.getBuildingNm();
        this.strDate=re.getStrDate();
        this.endDate=re.getEndDate();
        this.strTime=re.getStrTime();
        this.endTime=re.getEndTime();
        this.maxPeople = re.getMaxPeople();
        this.procedures = re.getProcedures();
        this.delYn = re.getDelYn();
    }
}

