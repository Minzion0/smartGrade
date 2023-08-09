package com.green.smartGrade.student.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StudentSelCurrentPasswordVo {
    private Long istudent;
    private String role;
    private String id;
    private String currentStudentPassword;
}
