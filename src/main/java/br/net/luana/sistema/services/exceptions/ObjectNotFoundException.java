package br.net.luana.sistema.services.exceptions;

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
