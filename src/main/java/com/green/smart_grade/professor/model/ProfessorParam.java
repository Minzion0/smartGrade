package com.green.smart_grade.professor.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfessorParam {
    private Long imajor;
    private String phone;
    private String email;
    private String address;
    private Long iprofessor;
}
