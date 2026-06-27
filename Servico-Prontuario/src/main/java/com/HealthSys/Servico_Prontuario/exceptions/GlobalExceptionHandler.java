package com.HealthSys.Servico_Prontuario.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<Object> buildResponse (HttpStatus httpStatus, String mensagem) {
        Map<String, Object> body = new HashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("status", httpStatus.value());
        body.put("error", httpStatus.getReasonPhrase());
        body.put("messagem", mensagem);

        return new ResponseEntity<>(body, httpStatus);
    }

    @ExceptionHandler(PacienteJaExisteException.class)
    public ResponseEntity<Object> handlePacienteJaExisteException (PacienteJaExisteException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(ProntuarioNotFoundException.class)
    public ResponseEntity<Object> handleProntuarioNotFoundException (ProntuarioNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
