package com.green.smart_grade.admin.major.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MajorVo {
    private Long imajor;
    private String majorName;
    private int graduationScore;
}
