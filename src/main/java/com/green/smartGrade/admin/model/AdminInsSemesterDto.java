package com.green.smartGrade.admin.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminInsSemesterDto {
    private int isemester;
    private String year;
    private int semester;
    private LocalDate semesterStrDate;
    private LocalDate semesterEndDate;

    public AdminInsSemesterDto(AdminInsSemesterParam param) {
        this.semester = param.getSemester();
        this.year= param.getYear();
        this.semesterStrDate = param.getSemesterStrDate();
        this.semesterEndDate = param.getSemesterEndDate();
    }
}
