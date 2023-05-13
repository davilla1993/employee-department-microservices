package com.gbossoufolly.departmentservice.handlers;

import com.gbossoufolly.departmentservice.exceptions.EntityAlreadyExistException;
import com.gbossoufolly.departmentservice.exceptions.EntityNotFoundException;
import com.gbossoufolly.departmentservice.exceptions.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest) {

        final HttpStatus notFound = HttpStatus.NOT_FOUND;

        final ErrorDto errorDto = ErrorDto.builder()
                .httpcode(notFound.value())
                .code(exception.getErrorCode())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();

        return new ResponseEntity<>(errorDto, notFound);

    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<ErrorDto> handleException(EntityAlreadyExistException exception, WebRequest webRequest) {

        final HttpStatus alreadyExist = HttpStatus.CONFLICT;

        final ErrorDto errorDto = ErrorDto.builder()
                .httpcode(alreadyExist.value())
                .code(exception.getErrorCode())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();

        return new ResponseEntity<>(errorDto, alreadyExist);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest) {

        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        final ErrorDto errorDto = ErrorDto.builder()
                .httpcode(badRequest.value())
                .code(exception.getErrorCode())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();

        return new ResponseEntity<>(errorDto, badRequest);
    }
}
