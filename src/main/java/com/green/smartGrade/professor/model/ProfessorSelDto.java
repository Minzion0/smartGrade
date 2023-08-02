package com.green.smartGrade.professor.model;

import lombok.Data;

@Data
public class ProfessorSelDto {
    private Long iprofessor;
    private int startIdx;
    private int page;
    private int row;
}
