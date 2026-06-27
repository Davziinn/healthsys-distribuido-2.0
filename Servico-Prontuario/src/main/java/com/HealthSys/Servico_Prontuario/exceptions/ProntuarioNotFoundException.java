package com.HealthSys.Servico_Prontuario.exceptions;

public class ProntuarioNotFoundException extends RuntimeException {
    public ProntuarioNotFoundException(String message) {
        super(message);
    }
}
