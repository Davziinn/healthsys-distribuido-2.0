package com.HealthSys.Servico_Usuarios.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<Object> buildResponse (HttpStatus httpStatus, String message) {
        Map<String, Object> body = new HashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("status", httpStatus.value());
        body.put("error", httpStatus.getReasonPhrase());
        body.put("message", message);

        return new ResponseEntity<>(body, httpStatus);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<Object> handleUsuarioNotFoundException (UsuarioNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException (MethodArgumentNotValidException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException (DataIntegrityViolationException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException (Exception ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
