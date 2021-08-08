package br.net.luana.sistema.services.exceptions;

import java.util.List;

public class NumeracaoRepetidaException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NumeracaoRepetidaException(String msg) {
        super(msg);
    }

    public NumeracaoRepetidaException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public NumeracaoRepetidaException(List<Integer> repetidos) {
        super("Foram informados os seguintes números repetidos para os itens da coleção: " + repetidos);
    }

    public NumeracaoRepetidaException(List<Integer> repetidos, Throwable cause) {
        super("Foram informados os seguintes números repetidos para os itens da coleção: " + repetidos, cause);
    }
}
