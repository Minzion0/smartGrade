package com.green.smartGrade.professor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ProfessorVo {
    private Long iprofessor;
    private Long imajor;
    private String name;
    private  char gender;
    private String pic;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;

}
