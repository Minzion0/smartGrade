package com.green.smartGrade.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class StudentSelCurrentPasswordVo {
    private Long istudent;
    private String role;
    private String id;
    private String currentStudentPassword;
}
