package com.green.smart_grade.admin.board.model;


import lombok.Data;


@Data
public class BoardUpdParam {
    private Long iboard;
    private String ctnt;
    private String title;
    private int importance;
}
