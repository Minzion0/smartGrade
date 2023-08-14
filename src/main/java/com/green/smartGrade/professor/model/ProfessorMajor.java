package com.green.smartGrade.professor.model;


import lombok.Data;

import java.time.LocalDate;
@Data
public class ProfessorMajor {
    private Long ilecture;
    private LocalDate lectureStrDate;
    private LocalDate lectureEndDate;
    private String  lectureStrTime;
    private String  lectureEndTime;
    private String lectureName;

}
