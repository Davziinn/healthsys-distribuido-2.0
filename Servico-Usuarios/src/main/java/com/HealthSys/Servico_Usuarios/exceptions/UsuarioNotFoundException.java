package com.HealthSys.Servico_Usuarios.exceptions;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String message) {
        super(message);
    }
}
