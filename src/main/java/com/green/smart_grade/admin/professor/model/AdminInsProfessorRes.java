package com.green.smart_grade.admin.professor.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AdminInsProfessorRes {
    private Long iprofessor;
    private Long imajor;
    private String nm;
    private String gender;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime createdAt;
    private int delYn;
    private String msg;

//    public AdminInsProfessorRes(AdminInsProfessorDto dto) {
//        this.iprofessor = dto.getIprofessor();
//        this.imajor = dto.getImajor();
//
//        this.nm = dto.getNm();
//        this.gender = dto.getGender();
//        this.birthdate = dto.getBirthdate();
//        this.phone = dto.getPhone();
//        this.email = dto.getEmail();
//        this.address = dto.getAddress();
//        this.createdAt = LocalDateTime.now();
//        this.delYn = 0;
//    }

    public void setRes(AdminInsProfessorDto dto){
        this.iprofessor = dto.getIprofessor();
        this.imajor = dto.getImajor();

        this.nm = dto.getNm();
        this.gender = dto.getGender();
        this.birthdate = dto.getBirthdate();
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.createdAt = LocalDateTime.now();
        this.delYn = 0;
    }
}
