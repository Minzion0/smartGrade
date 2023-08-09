package com.green.smartGrade.config.exception;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

public class AdminException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String  msg;
    private final String path;

    public AdminException(ErrorCode errorCode, String msg, String path) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.path = path;
    }
}
