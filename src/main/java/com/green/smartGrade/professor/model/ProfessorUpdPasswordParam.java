package com.green.smartGrade.professor.model;

import lombok.Data;

@Data
public class ProfessorUpdPasswordParam {
    private String professorPassword;
    private String currentProfessorPassword;
}
