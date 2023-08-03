package com.green.smartGrade.student.model;

import lombok.Data;

@Data
public class StudentUpParam {
    private Long studentNum;
    private String phone;
    private String email;
    private String address;
}
