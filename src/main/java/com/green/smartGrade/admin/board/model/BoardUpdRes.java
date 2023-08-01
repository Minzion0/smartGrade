package com.green.smartGrade.admin.board.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardUpdRes {
    private Long iboard;
    private String ctnt;
    private String title;
    private int importance;
    private int view;
    private LocalDateTime updatedAt;

    public BoardUpdRes(BoardUpdDto dto) {
        this.iboard = dto.getIboard();
        this.ctnt = dto.getCtnt();
        this.title = dto.getTitle();
        this.importance = dto.getImportance();
        this.view = dto.getView();
        this.updatedAt = LocalDateTime.now();
    }
}
