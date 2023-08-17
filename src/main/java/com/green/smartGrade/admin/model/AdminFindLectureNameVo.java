package com.green.smartGrade.admin.model;

import lombok.Data;

@Data
public class AdminFindLectureNameVo {
    private Long ilectureName;
    private String lectureName;
    private int score;
    private int delYn;
}
