package com.gbossoufolly.employeeservice.handlers;

import com.gbossoufolly.employeeservice.exceptions.EntityAlreadyExistException;
import com.gbossoufolly.employeeservice.exceptions.EntityNotFoundException;
import com.gbossoufolly.employeeservice.exceptions.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handle(EntityNotFoundException exception, WebRequest webRequest) {

        final HttpStatus notFound = HttpStatus.NOT_FOUND;

        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(notFound.value())
                .code(exception.getErrorCode())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();

        return new ResponseEntity<>(errorDto, notFound);
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<ErrorDto> handleException(EntityAlreadyExistException exception, WebRequest webRequest) {

        final HttpStatus alreadyExists = HttpStatus.CONFLICT;

        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(alreadyExists.value())
                .code(exception.getErrorCode())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();

        return new ResponseEntity<>(errorDto, alreadyExists);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest) {

        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(badRequest.value())
                .code(exception.getErrorCode())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();

        return new ResponseEntity<>(errorDto, badRequest);
    }
}
