package com.green.smartGrade.security.sign.model;

import lombok.Data;

@Data
public class SignUpResultDto {
    private boolean success;
    private int code;
    private boolean secretKey;
    private String msg;
}
