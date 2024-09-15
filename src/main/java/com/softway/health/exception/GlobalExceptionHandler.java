package com.softway.health.exception;

import com.softway.health.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleIllegalArgumentException(Exception ex) {
        return ResponseEntity.badRequest().body(new Response(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

}
