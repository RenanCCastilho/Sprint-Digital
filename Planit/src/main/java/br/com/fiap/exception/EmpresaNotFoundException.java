package br.com.fiap.exception;

public class EmpresaNotFoundException extends RuntimeException {

    public EmpresaNotFoundException() {
        super("Empresa não encontrada");
    }

    public EmpresaNotFoundException(String message) {
        super(message);
    }
}
