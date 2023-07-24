package com.green.smart_grade.admin.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardSelDetailVo {
    private Long iboard;
    private Long iadmin;
    private String title;
    private String ctnt;
    private int importance;
    private LocalDateTime createdAt;
    private int delYn;
}
