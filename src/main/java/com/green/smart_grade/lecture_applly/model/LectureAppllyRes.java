package com.green.smart_grade.lecture_applly.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class LectureAppllyRes {
    private Long ilecture;
    private Long ilectureName;
    private Long ilectureRoom;
    private Long iprofessor;
    private Long isemester;
    private int openingProcedures;
    private LocalDate lectureStrDate;
    private LocalDate lectureEndDate;
    private LocalDateTime lectureStrTime;
    private LocalDateTime lectureEndTime;
    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int lectureMaxPeople;
    private int garedLimit;
    private int delYn;

    public LectureAppllyRes(LectureAppllyInsDto dto) {
        this.ilecture = dto.getIlecture();
        this.ilectureName = dto.getIlectureName();
        this.ilectureRoom = dto.getIlectureRoom();
        this.iprofessor = dto.getIprofessor();
        this.isemester = dto.getIsemester();
        this.openingProcedures = dto.getOpeningProcedures();
        this.lectureStrDate = dto.getLectureStrDate();
        this.lectureEndDate = dto.getLectureEndDate();
        this.lectureStrTime = dto.getLectureStrTime();
        this.lectureEndTime = dto.getLectureEndTime();
        this.attendance = dto.getAttendance();
        this.midtermExamination = dto.getMidtermExamination();
        this.finalExamination = dto.getFinalExamination();
        this.lectureMaxPeople = dto.getLectureMaxPeople();
        this.garedLimit = dto.getGaredLimit();
        this.delYn = dto.getDelYn();
    }


}
