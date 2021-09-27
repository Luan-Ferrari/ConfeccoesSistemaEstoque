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
        super("A soma das porcentagens informadas não é 100% para " +
                "composição simples ou de 85% para composições 'Mínimo 85%'");
    }

    public PorcentagemComposicaoException(Throwable cause) {
        super("A soma das porcentagens informadas não é 100% para " +
                "composição simples ou de 85% para composições 'Mínimo 85%'", cause);
    }
}
