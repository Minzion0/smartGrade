package com.green.smart_grade.admin.board.model;

import lombok.Data;

@Data
public class BoardInsDto {
    private Long iboard;
    private Long iadmin;
    private String ctnt;
    private int importance;
}
