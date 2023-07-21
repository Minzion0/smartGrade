package com.green.smart_grade.professor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ProfessorVo {
    private Long iprofessor;
    private Long imajor;
    private String name;
    private  char gender;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;



}
