package com.green.smartGrade.student.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class StudentInsRes {
    private Long ilectureStudent;
    private Long istudent;
    private Long ilecture;
    private int finishedYn;
    private String dayWeek;
    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int totalScore;
    private LocalDate createdAt;
    private int delYn;

    public StudentInsRes() {
    }

    public StudentInsRes(StudentInsDto dto) {
        this.ilectureStudent = dto.getIlectureStudent();
        this.istudent = dto.getIstudent();
        this.ilecture = dto.getIlecture();
        this.finishedYn =  dto.getFinishedYn();
        this.dayWeek = dto.getDayWeek();
        this.attendance = dto.getAttendance();
        this.midtermExamination = dto.getMidtermExamination();
        this.finalExamination =dto.getFinalExamination();
        this.totalScore = dto.getTotalScore();
        this.createdAt = LocalDate.now();
        this.delYn = dto.getFinishedYn();
    }



}
