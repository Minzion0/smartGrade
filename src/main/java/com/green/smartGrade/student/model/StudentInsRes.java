package com.green.smartGrade.student.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class StudentInsRes {
    private Long ilectureStudent;
    private Long isudent;
    private Long ilecture;
    private int finishedYn;
    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int totalScore;
    private LocalDate createdAt;
    private int delYn;

    public StudentInsRes(StudentInsDto dto) {
        this.ilectureStudent = dto.getIlectureStudent();
        this.isudent = dto.getIsudent();
        this.ilecture = dto.getIlecture();
        this.finishedYn =  dto.getFinishedYn();
        this.attendance = dto.getAttendance();
        this.midtermExamination = dto.getMidtermExamination();
        this.finalExamination =dto.getFinalExamination();
        this.totalScore = dto.getTotalScore();
        this.createdAt = dto.getCreatedAt();
        this.delYn = dto.getFinishedYn();
    }



}
