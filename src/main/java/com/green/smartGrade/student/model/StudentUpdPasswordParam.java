package com.green.smartGrade.student.model;

import lombok.Data;

@Data
public class StudentUpdPasswordParam {
    private String studentPassword;
    private String currentStudentPassword;
}
