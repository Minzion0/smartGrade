package com.green.smartGrade.admin.student.model;

import lombok.Data;

@Data
public class AdminStudentLectureDataRes {
    private Long ilecture;
    private String lectureNm;
    private String  lectureStrDate;
    private String  lectureEndDate;
    private String  lectureStrTime;
    private String  lectureEndTime;
}
