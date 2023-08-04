package com.green.smartGrade.professor.professorgradeMngmn.model;

import com.green.smartGrade.utils.GradeUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.Data;

@Data
public class ProfessorGradeUpdDto {
    private Long istudent;
    private int semester;
    private double rating;
}
