package br.net.luana.sistema.services.exceptions;

import br.net.luana.sistema.domain.Fornecedor;

import java.io.Serializable;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ObjectNotFoundException(Integer id) {
        super("Objeto não Encontrado! Parametro: " + id);
    }

    public ObjectNotFoundException(Integer id, Throwable cause) {
        super("Objeto não Encontrado! Parametro: " + id, cause);
    }
}
