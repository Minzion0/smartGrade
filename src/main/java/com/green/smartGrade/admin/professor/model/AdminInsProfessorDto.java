package com.green.smartGrade.admin.professor.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminInsProfessorDto {
    private Long iprofessor;
    private Long imajor;
    private String professorPassword;
    private String nm;
    private String gender;
    private LocalDate birthdate;
    private String phone;


    public AdminInsProfessorDto(AdminInsProfessorParam param) {

        this.imajor = param.getImajor();
        this.nm = param.getNm();
        this.gender = param.getGender();
        this.birthdate = param.getBirthdate();
        this.phone = param.getPhone();

    }
}
