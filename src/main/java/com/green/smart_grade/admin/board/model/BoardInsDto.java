package com.green.smart_grade.admin.board.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardInsDto {
    private Long iboard;
    private Long iadmin;
    private String ctnt;
    private String title;
    private int importance;
}
