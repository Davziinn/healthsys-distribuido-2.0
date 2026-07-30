package com.HealthSys.Servico_Prontuario.exceptions;

public class PacienteServiceIndisponivelException extends RuntimeException {
    public PacienteServiceIndisponivelException(String message) {
        super(message);
    }
}
