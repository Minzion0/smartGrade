package com.green.smart_grade.admin.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardSelVo {
    private Long iadmin;
    private String title;
    private int importance;
    private LocalDateTime createdAt;
}
