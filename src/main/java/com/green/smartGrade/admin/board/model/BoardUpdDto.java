package com.green.smartGrade.admin.board.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardUpdDto {
    private Long iboard;
    private String ctnt;
    private String title;
    private int importance;
    private int view;
    private LocalDateTime updatedAt;
}
