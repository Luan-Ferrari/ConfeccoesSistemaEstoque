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

    public DataIntegrityException(Integer id, String className, String associatedClassName) {
        super("Impossível excluir recurso ID: " + id + " da classe " + className + " por possuir recursos da classe "
                + associatedClassName + " associados");
    }

    public DataIntegrityException(Integer id, String className, String associatedClassName, Throwable cause) {
        super("Impossível excluir recurso ID: " + id + " da classe " + className + " por possuir recursos da classe "
                + associatedClassName + " associados", cause);
    }
}
