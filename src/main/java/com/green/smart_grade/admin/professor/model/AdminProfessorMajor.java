package com.green.smart_grade.admin.professor.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AdminProfessorMajor {
    private LocalDate lectureStrDate;
    private LocalDate lectureEndDate;
    private LocalDateTime lectureStrTime;
    private LocalDateTime lectureEndTime;
    private String lectureName;
}
