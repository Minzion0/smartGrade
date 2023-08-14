package com.green.smartGrade.admin.professor.model;

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
    private LocalDateTime createdAt;
    private int delYn;



    public void setRes(AdminInsProfessorDto dto){
        this.iprofessor = dto.getIprofessor();
        this.imajor = dto.getImajor();
        this.nm = dto.getNm();
        this.gender = dto.getGender();
        this.birthdate = dto.getBirthdate();
        this.phone = dto.getPhone();

        this.createdAt = LocalDateTime.now();
        this.delYn = 0;
    }
}
