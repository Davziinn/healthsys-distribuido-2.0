package com.HealthSys.Servico_Pacientes.exceptions;

public class UsuarioServiceIndisponivelException extends RuntimeException {
    public UsuarioServiceIndisponivelException(String message) {
        super(message);
    }
}
