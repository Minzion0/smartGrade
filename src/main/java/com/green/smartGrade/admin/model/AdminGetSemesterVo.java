package com.green.smartGrade.admin.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminGetSemesterVo {
    private Long isemester;
    private String year;
    private int semester;
    private LocalDate semesterStrDate;
    private LocalDate semesterEndDate;
}
