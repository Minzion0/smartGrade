package com.green.smartGrade.admin.board.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardEntity {
    private Long iboard;
    private Long iadmin;
    private String ctnt;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int importance;
    private int view;
}
