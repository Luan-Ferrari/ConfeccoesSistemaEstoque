package br.net.luana.sistema.services.exceptions;

public class FileException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FileException(String msg) {
        super(msg);
    }

    public FileException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public FileException(Integer id) {
        super("Impossível excluir recurso ID " + id + " por possuir recursos associados");
    }

    public FileException(Integer id, Throwable cause) {
        super("Impossível excluir recurso ID " + id + " por possuir recursos associados", cause);
    }
}
