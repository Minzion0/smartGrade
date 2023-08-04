package com.green.smartGrade.admin.professor.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminInsProfessorParam {
    private Long imajor;
    private String nm;
    private String gender;
    private LocalDate birthdate;
    private String phone;

}
