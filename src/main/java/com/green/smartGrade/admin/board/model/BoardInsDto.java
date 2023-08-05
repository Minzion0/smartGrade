package com.green.smartGrade.admin.board.model;

import lombok.Data;

@Data
public class BoardInsDto {
    private Long iboard;
    private Long iadmin;
    private String ctnt;
    private String title;
    private int importance;
}
