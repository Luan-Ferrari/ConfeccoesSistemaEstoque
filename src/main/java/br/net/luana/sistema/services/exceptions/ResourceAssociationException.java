package br.net.luana.sistema.services.exceptions;

public class ResourceAssociationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceAssociationException(String msg) {
        super(msg);
    }

    public ResourceAssociationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ResourceAssociationException(Integer id) {
        super("Recurso com id " + id + " não é um recurso válido para associação ao recurso que esta sendo criado");
    }

    public ResourceAssociationException(Integer id, Throwable cause) {
        super("Recurso com id " + id + " não é um recurso válido para associação ao recurso que esta sendo criado", cause);
    }
}
