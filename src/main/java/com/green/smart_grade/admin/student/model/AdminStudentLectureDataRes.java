package com.green.smart_grade.admin.student.model;

import lombok.Data;

@Data
public class AdminStudentLectureDataRes {
    private Long ilecture;
    private String lectureNm;
    private int attendance;
    private int mixEx;
    private int finEx;
    private int totalScore;
}
