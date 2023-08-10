package com.green.smartGrade.config.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(AdminException.class)
    public ResponseEntity<Object> handleAdminExcoption(AdminException e){
        return handleAdminExceptionSet(CommonErrorCode.ADMIN_EXCEPTION, e.getMsg());
    }


    // IllegalArgumentException 에러 처리
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException e) {
        log.warn("handleIllegalArgument", e);
        return handleExceptionInternal(CommonErrorCode.FIX_EXCEPTION, e.getMessage());
    }

    // 대부분의 에러 처리
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAllException(Exception ex) {
        log.warn("handleAllException", ex);
        if (ex.getMessage()!=null){
            return handleExceptionInternal(CommonErrorCode.FIX_EXCEPTION,ex.getMessage());
        }
        return handleExceptionInternal(CommonErrorCode.FIX_EXCEPTION,"관리자에 문의");
    }

    // RuntimeException과 대부분의 에러 처리 메세지를 보내기 위한 메소드
    private ResponseEntity<Object> handleExceptionInternal(ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(makeErrorResponse(errorCode));
    }

    private ResponseEntity<Object> handleAdminExceptionSet(ErrorCode errorCode,String msg){
        return ResponseEntity.status(errorCode.getHttpStatus()).body(makeErrorResponse(errorCode,msg));
    }

    // 코드 가독성을 위해 에러 처리 메세지를 만드는 메소드 분리
    private MyErrorResponse makeErrorResponse(ErrorCode errorCode) {
        return MyErrorResponse.builder()
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .build();
    }

    private ResponseEntity<Object> handleExceptionInternal(ErrorCode errorCode, String message) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(makeErrorResponse(errorCode, message));
    }
    private MyErrorResponse makeErrorResponse(ErrorCode errorCode, String message) {
        return MyErrorResponse.builder()
                .code(errorCode.name())
                .message(message)
                .build();
    }
    // 코드 가독성을 위해 에러 처리 메세지를 만드는 메소드 분리
    private MyErrorResponse makeErrorResponse(ErrorCode errorCode, String message,String path) {
        return MyErrorResponse.builder()
                .code(errorCode.getMessage())
                .message(message)

                .build();
    }

    // @Valid 어노테이션으로 넘어오는 에러 처리 메세지를 보내기 위한 메소드
    private ResponseEntity<Object> handleExceptionInternal(BindException e, ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(makeErrorResponse(e, errorCode));
    }

    // 코드 가독성을 위해 에러 처리 메세지를 만드는 메소드 분리
    private MyErrorResponse makeErrorResponse(BindException e, ErrorCode errorCode) {
        List<MyErrorResponse.ValidationError> validationErrorList = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(MyErrorResponse.ValidationError::of)
                .collect(Collectors.toList());

        return MyErrorResponse.builder()
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .errors(validationErrorList)
                .build();
    }
}
