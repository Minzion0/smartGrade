package com.green.smart_grade.admin.model;

import lombok.Data;

@Data
public class AdminSelLectureDto {
    private int procedures;
    private String nm;
    private int strIdx;
    private int row;

    public AdminSelLectureDto() {
    }

    public AdminSelLectureDto(AdminSelLectureParam param) {
        this.procedures = param.getProcedures();
        this.nm = param.getNm();

    }
}
