package com.green.smartGrade.student.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentInsDto {
    private Long ilectureStudent;
    private Long isudent;
    private Long ilecture;
    private LocalDate createdAt;
    private int delYn;
}
