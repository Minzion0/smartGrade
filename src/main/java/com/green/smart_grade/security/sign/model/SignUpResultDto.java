package com.green.smart_grade.security.sign.model;

import lombok.Data;

@Data
public class SignUpResultDto {
    private boolean success;
    private int code;
    private String msg;
}
