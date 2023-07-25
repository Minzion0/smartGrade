package com.green.smart_grade.admin.model;

import lombok.Data;

@Data
public class AdminUpdLectureRes {
    private Long ilecture;
    private String ctnt;

    public AdminUpdLectureRes(AdminUpdLectureDto dto) {
        this.ilecture = dto.getIlecture();
        this.ctnt = dto.getCtnt();
    }
}
