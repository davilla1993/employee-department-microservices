package com.gbossoufolly.employeeservice.exceptions;

public enum ErrorCode {

    EMPLOYEE_NOT_FOUND(2000), EMPLOYEE_NOT_VALID(2001), EMPLOYEE_ALREADY_EXISTS(2002);
    private int code;

    ErrorCode(int code) {
        this.code = code;
    }
}
