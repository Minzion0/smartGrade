package com.green.smartGrade.security.sign.model;

import lombok.Data;

@Data
public class StudentUpdForgetPasswordDto {
    private String studentPassword;
    private int studentNum;
    private String role;
}
