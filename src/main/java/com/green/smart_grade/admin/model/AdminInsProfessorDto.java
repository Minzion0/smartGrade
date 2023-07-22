package com.green.smart_grade.admin.model;

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
    private String email;
    private String address;

    public AdminInsProfessorDto(AdminInsProfessorParam param) {

        this.imajor = param.getImajor();
        this.nm = param.getNm();
        this.gender = param.getGender();
        this.birthdate = param.getBirthdate();
        this.phone = param.getPhone();
        this.email = param.getEmail();
        this.address = param.getAddress();
    }
}
