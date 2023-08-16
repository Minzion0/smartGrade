package com.green.smartGrade.professor.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProfessorDatilProfile {
    private Long iprofessor;
    private String name;
    private String gender;
    private String birthdate;
    private String phone;
    private String pic;
    private String address;
    private String email;
    private Long imajor;
    private String majorName;
    private LocalDateTime createdAt;
    private int delYn;
    private String secretKey;
}
