package com.green.smartGrade.security.config.security.model;

import lombok.Data;

@Data
public class OtpValidParam {
    private String otpNum;
    private String uid;
    private String role;
}
