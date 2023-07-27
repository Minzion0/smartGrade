package com.green.smart_grade.admin.student.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AdminStudentLectureDataRes {
    private Long ilecture;
    private String lectureNm;
    private String  lectureStrDate;
    private String  lectureEndDate;
    private String  lectureStrTime;
    private String  lectureEndTime;
}
