package com.green.smartGrade.professor.professorgradeMngmn.model;

import lombok.Data;

@Data
public class ProfessorGradeUpdDto {
    private Long istudent;
    private int semester;
    private double rating;
}
