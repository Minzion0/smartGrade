package com.green.smartGrade.config.exception;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

public class AdminException extends RuntimeException {
    private  ErrorCode errorCode;
    private  String  msg;


    public AdminException(String msg){
        this.msg=msg;
    }
    public AdminException( String msg, String path) {
        this.errorCode = CommonErrorCode.ADMIN_PROFESSOR_ERROR;
        this.msg = msg;

    }
}
