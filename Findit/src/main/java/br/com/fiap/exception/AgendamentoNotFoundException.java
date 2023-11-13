package br.com.fiap.exception;

public class AgendamentoNotFoundException extends RuntimeException {

    public AgendamentoNotFoundException() {
        super("Agendamento não encontrado");
    }

    public AgendamentoNotFoundException(String message) {
        super(message);
    }
}
