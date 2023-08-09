package com.green.smartGrade.admin.major.model;

import lombok.Data;

@Data
public class MajorUpdRes {
    private Long imajor;
    private String majorName;

    public MajorUpdRes(MajorUpdParam p) {
        this.imajor = p.getImajor();
        this.majorName = p.getMajorName();
    }
}
