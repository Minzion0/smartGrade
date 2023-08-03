package com.green.smartGrade.student.model;

import lombok.Data;

@Data
public class StudentUpdto {
    private Long studentNum;
    private String phone;
    private String email;
    private String address;
    private int strIdx;
    private int row;
}
