package com.green.smartGrade.security.config.security.model;

import lombok.Data;

@Data
public class UserUpdSecretKeyDto {
    private String role;
    private String secretKey;
    private String uid;
}
