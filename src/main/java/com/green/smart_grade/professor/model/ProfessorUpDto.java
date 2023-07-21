package com.green.smart_grade.professor.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfessorUpDto {
    private Long iprofessor;
    private Long imajor;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;

}
