package com.green.smartGrade.student.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentParam {

    private Long isudent;
    private Long ilecture;
    private int finishedYn;
    private LocalDate createdAt;
}
