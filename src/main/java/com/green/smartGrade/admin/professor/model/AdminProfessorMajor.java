package com.green.smartGrade.admin.professor.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AdminProfessorMajor {
    private Long ilecture;
    private LocalDate lectureStrDate;
    private LocalDate lectureEndDate;
    private String  lectureStrTime;
    private String  lectureEndTime;
    private String lectureName;
}
