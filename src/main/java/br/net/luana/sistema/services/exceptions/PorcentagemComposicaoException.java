package br.net.luana.sistema.services.exceptions;

public class PorcentagemComposicaoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public PorcentagemComposicaoException(String msg) {
        super(msg);
    }

    public PorcentagemComposicaoException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public PorcentagemComposicaoException() {
        super("A soma das porcentagens informadas não é 100%");
    }

    public PorcentagemComposicaoException(Throwable cause) {
        super("A soma das porcentagens informadas não é 100%", cause);
    }
}
