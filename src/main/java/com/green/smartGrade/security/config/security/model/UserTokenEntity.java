package com.green.smartGrade.security.config.security.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTokenEntity {
    private Long iuser;
    private String role;
    private String ip;
    private String createdAt;
    private String updatedAt;
}
