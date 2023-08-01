package com.green.smartGrade.admin.board.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardInsRes {
    private Long iboard;
    private Long iadmin;
    private String ctnt;
    private String title;
    private int importance;
    private int view;
    private LocalDateTime createdAt;

    public BoardInsRes(BoardInsDto dto) {
        this.iboard = dto.getIboard();
        this.iadmin = dto.getIadmin();
        this.ctnt = dto.getCtnt();
        this.title = dto.getTitle();
        this.importance = dto.getImportance();
        this.createdAt = LocalDateTime.now();
    }
}
