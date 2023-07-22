package com.green.smart_grade.admin.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminFindProfessorRes {
    private Long iprofessor;
    private String majorName;
    private String nm;
    private String gender;
    private LocalDate birthdate;
    private String phone;
    private String email;
    private String address;
    private int delYn;
}
