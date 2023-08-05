package com.green.smartGrade.admin.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardSelImportanceVo {
    private Long iboard;
    private Long iadmin;
    private String title;
    private int importance;
    private LocalDateTime createdAt;
    private int delYn;
    private int boardView;
}
