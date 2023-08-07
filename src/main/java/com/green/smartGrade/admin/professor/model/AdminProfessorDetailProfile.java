package com.green.smartGrade.admin.professor.model;

import lombok.Data;


import java.time.LocalDateTime;

@Data
public class AdminProfessorDetailProfile {
    private String name;
    private String gender;
    private String birthDate;
    private String phone;
    private String address;
    private String email;
    private Long imajor;
    private LocalDateTime createdAt;
}
