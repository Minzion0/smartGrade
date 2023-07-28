package com.green.smart_grade.professor.professorgradeMngmn.model;

import lombok.Data;

@Data
public class ProfessorGradeUpdParam {
    private int totalScore;
    private int avgScore;
    private double rating;
    private Long istudent;
    private int semester;
}
