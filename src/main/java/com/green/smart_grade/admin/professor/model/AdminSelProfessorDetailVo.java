package com.green.smart_grade.admin.professor.model;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AdminSelProfessorDetailVo {
    private LocalDate lectureStrDate;
    private LocalDate lectureEndDate;
    private LocalDateTime lectureStrTime;
    private LocalDateTime lectureEndTime;
    private String lectureName;
    private String name;
    private char gender;
    private LocalDate birthDate;
    private String phone;
    private String address;
    private String email;
    private String majorName;
    private LocalDateTime createdAt;
}
