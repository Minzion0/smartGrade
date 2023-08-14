package com.green.smartGrade.config.exception;

import lombok.Getter;


@Getter

public class AdminException extends RuntimeException {
    private  ErrorCode errorCode;
    private  String   msg;

    public AdminException(String msg){
        this.msg=msg;
    }

}
