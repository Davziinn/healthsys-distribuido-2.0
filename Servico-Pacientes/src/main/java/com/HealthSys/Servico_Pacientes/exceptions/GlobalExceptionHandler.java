package com.HealthSys.Servico_Pacientes.exceptions;

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
        body.put("message", mensagem);

        return new ResponseEntity<>(body, httpStatus);
    }

    @ExceptionHandler(PacienteNotFoundException.class)
    public ResponseEntity<Object> handlePacienteNotFoundException (PacienteNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(ListaAtendimentosPacienteVaziaException.class)
    public ResponseEntity<Object> handleListaAtendimentosPacienteVaziaException (ListaAtendimentosPacienteVaziaException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
