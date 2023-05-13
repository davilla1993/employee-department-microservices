package com.gbossoufolly.departmentservice.exceptions;

public enum ErrorCode {

    DEPARTMENT_NOT_FOUND(1000), DEPARTMENT_NOT_VALID(1001), DEPARTMENT_ALREADY_USE(1002);
    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
