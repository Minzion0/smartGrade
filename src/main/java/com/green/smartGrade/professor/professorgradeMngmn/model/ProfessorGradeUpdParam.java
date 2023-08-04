package com.green.smartGrade.professor.professorgradeMngmn.model;

import com.green.smartGrade.utils.GradeUtils;
import lombok.Data;

@Data
public class ProfessorGradeUpdParam {
    private int totalScore;
    private int avgScore;
    private double rating;
    private Long istudent;
    private int semester;
}
