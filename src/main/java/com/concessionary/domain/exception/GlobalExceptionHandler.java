package com.concessionary.domain.exception;

import com.concessionary.domain.model.error.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(CarOwnerNotFoundException.class)
    public ResponseEntity<Object> carOwnerNotFoundRes(Exception ex, WebRequest request)
    {
        ErrorResponse response = new ErrorResponse(LocalDateTime.now(), ex.getMessage());
        return handleExceptionInternal(ex, response, null, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<Object> carNotFoundRes(Exception ex, WebRequest request)
    {
        ErrorResponse response = new ErrorResponse(LocalDateTime.now(), ex.getMessage());
        return handleExceptionInternal(ex, response, null, HttpStatus.NOT_FOUND, request);
    }

    //@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldError = result.getFieldErrors();
        List<String> errors = new ArrayList<>();
        for(FieldError error : fieldError) {
            errors.add(error.getDefaultMessage());
        }

        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),"Bad request", errors);
        return handleExceptionInternal(ex, errorResponse, headers, status, request);
    }
}
