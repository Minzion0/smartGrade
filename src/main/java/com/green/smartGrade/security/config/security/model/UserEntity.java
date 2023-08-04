package com.green.smartGrade.security.config.security.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {
    private Long iuser;
    private String uid;
    private String upw;
    private String role;
    private String secretKey;

}
