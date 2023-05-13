package com.gbossoufolly.departmentservice.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class InvalidEntityException extends RuntimeException{

    private ErrorCode errorCode;

    private List<String> errors;

    public InvalidEntityException(ErrorCode errorCode, List<String> errors) {
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public InvalidEntityException(String message, ErrorCode errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCode errorCode, List<String> errors) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public InvalidEntityException(Throwable cause, ErrorCode errorCode, List<String> errors) {
        super(cause);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public InvalidEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode errorCode, List<String> errors) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
