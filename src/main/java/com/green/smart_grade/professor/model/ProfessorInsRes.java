package com.green.smart_grade.professor.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfessorInsRes {
    private Long imajor;
    private String password;
    private String name;
    private  char gender;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;
    private Long iprofessor;


    public ProfessorInsRes(ProfessorUpDto dto) {
        this.password = dto.getPassword();
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.iprofessor = dto.getIprofessor();
    }
}
