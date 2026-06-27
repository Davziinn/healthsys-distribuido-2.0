package com.HealthSys.Servico_Prontuario.exceptions;

public class PacienteJaExisteException extends RuntimeException {
    public PacienteJaExisteException(String message) {
        super(message);
    }
}
