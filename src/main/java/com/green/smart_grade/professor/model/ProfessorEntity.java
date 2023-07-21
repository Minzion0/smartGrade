package com.green.smart_grade.professor.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfessorEntity {
    private Long iprofessor;
    private Long imajor;
    private String password;
    private String name;
    private  char gender;
    private String pic;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;
    private String grade;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
