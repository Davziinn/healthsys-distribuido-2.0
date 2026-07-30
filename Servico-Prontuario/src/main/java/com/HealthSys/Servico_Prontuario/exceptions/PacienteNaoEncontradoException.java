package com.HealthSys.Servico_Prontuario.exceptions;

public class PacienteNaoEncontradoException extends RuntimeException {
    public PacienteNaoEncontradoException(String message) {
        super(message);
    }
}
