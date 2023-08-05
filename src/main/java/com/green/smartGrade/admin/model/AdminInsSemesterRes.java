package com.green.smartGrade.admin.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminInsSemesterRes {
    private int isemester;
    private int semester;
    private LocalDate semesterStrDate;
    private LocalDate semesterEndDate;
    private int delYn;
    private String msg;

    public void semesterSet(AdminInsSemesterDto dto) {
        this.isemester = dto.getIsemester();
        this.semester = dto.getSemester();
        this.semesterStrDate = dto.getSemesterStrDate();
        this.semesterEndDate = dto.getSemesterEndDate();
        this.delYn = 0;
    }
}
