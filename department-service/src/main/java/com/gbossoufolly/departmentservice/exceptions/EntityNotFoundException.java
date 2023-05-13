package com.gbossoufolly.departmentservice.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class EntityNotFoundException extends RuntimeException{

    @Getter
    private ErrorCode errorCode;

    @Getter
    private List<String> errors;


    public EntityNotFoundException(ErrorCode error, List<String> errors) {
        this.errorCode = error;
        this.errors = errors;
    }

    public EntityNotFoundException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public EntityNotFoundException(String message, ErrorCode error, List<String> errors) {
        super(message);
        this.errorCode = error;
        this.errors = errors;
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorCode error, List<String> errors) {
        super(message, cause);
        this.errorCode = error;
        this.errors = errors;
    }

    public EntityNotFoundException(Throwable cause, ErrorCode error, List<String> errors) {
        super(cause);
        this.errorCode = error;
        this.errors = errors;
    }

    public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode error, List<String> errors) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = error;
        this.errors = errors;
    }
}
