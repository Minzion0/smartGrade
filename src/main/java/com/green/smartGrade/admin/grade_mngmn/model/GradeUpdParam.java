package com.green.smartGrade.admin.grade_mngmn.model;

import com.green.smartGrade.utils.GradeUtils;
import lombok.Data;

@Data
public class GradeUpdParam {
    private int totalScore;
    private int avgScore;
    private GradeUtils rating;
    private Long istudent;
    private int semester;
}
