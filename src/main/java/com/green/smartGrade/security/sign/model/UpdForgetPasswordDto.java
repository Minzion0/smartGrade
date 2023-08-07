package com.green.smartGrade.security.sign.model;

import lombok.Data;

@Data
public class UpdForgetPasswordDto {
    private String upw;
    private int uid;
    private String role;
}
