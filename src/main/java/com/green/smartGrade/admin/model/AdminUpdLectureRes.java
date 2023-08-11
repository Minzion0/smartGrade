package com.green.smartGrade.admin.model;

import lombok.Data;

@Data
public class AdminUpdLectureRes {
    private Long ilecture;
    private int procedures;
    private String ctnt;

    public AdminUpdLectureRes(AdminUpdLectureDto dto) {
        this.ilecture = dto.getIlecture();
        this.procedures= dto.getProcedures();
        this.ctnt = dto.getCtnt();
    }
}
