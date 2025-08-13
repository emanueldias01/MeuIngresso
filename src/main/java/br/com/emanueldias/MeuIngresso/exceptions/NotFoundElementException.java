package br.com.emanueldias.MeuIngresso.exceptions;

public class NotFoundElementException extends RuntimeException{
    private final String lancamento = "Elemento não encontrado";

    public NotFoundElementException(String message) {
        super(message);
    }

    public String getLancamento() {
        return lancamento;
    }
}
