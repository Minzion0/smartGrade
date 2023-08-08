package com.green.smartGrade.student.model;

import lombok.Data;

@Data
public class StudentUpdPasswordDto {
    private String studentPassword;
    private Long istudent;
    private String role;
}
