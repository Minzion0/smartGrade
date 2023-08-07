package com.green.smartGrade.security.sign.model;

import lombok.Data;

@Data
public class ProfessorUpdForgetPasswordDto {
    private String professorPassword;
    private int iprofessor;
    private String role;
}
