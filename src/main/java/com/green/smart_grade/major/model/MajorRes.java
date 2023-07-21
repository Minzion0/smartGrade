package com.green.smart_grade.major.model;

import lombok.Data;

@Data
public class MajorRes {
    private Long imajor;
    private String majorName;
    private int graduationScore;

    public MajorRes(MajorInsDto dto) {
        this.imajor = dto.getImajor();
        this.majorName = dto.getMajorName();
        this.graduationScore = dto.getGraduationScore();
    }
}
