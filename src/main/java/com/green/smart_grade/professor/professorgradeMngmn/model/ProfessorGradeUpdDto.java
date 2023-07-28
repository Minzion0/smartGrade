package com.green.smart_grade.professor.professorgradeMngmn.model;

import com.green.smart_grade.utils.GradeUtils;
import lombok.Data;

@Data
public class ProfessorGradeUpdDto {
    private Long istudent;
    private int semester;
    private double rating;
}
