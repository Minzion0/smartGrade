package com.green.smartGrade.admin.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminInsSemesterParam {
    private String year;
    private int semester;
    private LocalDate semesterStrDate;
    private LocalDate semesterEndDate;
}
