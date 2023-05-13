package com.gbossoufolly.employeeservice.handlers;

import com.gbossoufolly.employeeservice.exceptions.ErrorCode;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorDto {

    private ErrorCode code;

    private Integer httpCode;

    private String message;

    private List<String> errors;

}
