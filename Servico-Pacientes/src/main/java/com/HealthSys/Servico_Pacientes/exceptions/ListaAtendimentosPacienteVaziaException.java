package com.HealthSys.Servico_Pacientes.exceptions;

public class ListaAtendimentosPacienteVaziaException extends RuntimeException {
    public ListaAtendimentosPacienteVaziaException(String message) {
        super(message);
    }
}
