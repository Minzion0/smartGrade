package com.green.smartGrade.professor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProfessorSelCurrentPasswordVo {
    private String id;
    private String role;
    private String currentStudentPassword;
}
