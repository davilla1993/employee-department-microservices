package com.gbossoufolly.departmentservice.handlers;

import com.gbossoufolly.departmentservice.exceptions.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorDto {

    private Integer httpcode;

    private ErrorCode code;

    private String message;

    private List<String> errors = new ArrayList<>();

}
