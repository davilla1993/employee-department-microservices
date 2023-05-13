package com.gbossoufolly.departmentservice.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class EntityAlreadyExistException extends RuntimeException{

    private ErrorCode errorCode;

    private List<String> errors;


    public EntityAlreadyExistException(ErrorCode errorCode, List<String> errors) {
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public EntityAlreadyExistException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public EntityAlreadyExistException(String message, ErrorCode errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public EntityAlreadyExistException(String message, Throwable cause, ErrorCode errorCode, List<String> errors) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public EntityAlreadyExistException(Throwable cause, ErrorCode errorCode, List<String> errors) {
        super(cause);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public EntityAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode errorCode, List<String> errors) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
