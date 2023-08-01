package com.green.smartGrade.professor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ProfessorLoginVo {
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
