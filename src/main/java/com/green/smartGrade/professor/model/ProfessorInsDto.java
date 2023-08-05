package com.green.smartGrade.professor.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfessorInsDto {
    private Long iprofessor;
    private Long imajor;
    private String password;
    private String name;
    private  char gender;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;
}

