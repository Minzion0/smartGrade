package com.green.smart_grade.professor.model;

import lombok.Data;

@Data
public class ProfessorUpRes {
    private Long imajor;
    private String phone;
    private String email;
    private String address;
    private Long iprofessor;



    public ProfessorUpRes(ProfessorUpDto dto) {
        this.imajor = dto.getImajor();
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.iprofessor= dto.getIprofessor();

    }


}

