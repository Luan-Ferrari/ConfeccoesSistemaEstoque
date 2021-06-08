package br.net.luana.sistema.services.exceptions;

import org.springframework.dao.NonTransientDataAccessException;

public class DataIntegrityException extends NonTransientDataAccessException {
    private static final long serialVersionUID = 1L;

    public DataIntegrityException(String msg) {
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DataIntegrityException(Integer id) {
        super("Impossível excluir recurso ID " + id + " por possuir recursos associados");
    }

    public DataIntegrityException(Integer id, Throwable cause) {
        super("Impossível excluir recurso ID " + id + " por possuir recursos associados", cause);
    }
}
