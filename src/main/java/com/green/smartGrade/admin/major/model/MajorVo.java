package com.green.smartGrade.admin.major.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MajorVo {
    private Long imajor;
    private String majorName;
    private int graduationScore;
    private int delYn;
    private String remarks;
}
