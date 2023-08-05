package com.green.smartGrade.professor.professorgradeMngmn.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessorGradeUpdRes {
    private int totalScore;
    private int avgScore;
    private double rating;
    private Long istudent;
    private int semester;


}
