package br.net.luana.sistema.services.exceptions;

import br.net.luana.sistema.domain.Fornecedor;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ObjectNotFoundException(Integer id, String className) {
        super("Objeto não Encontrado! Parametro: " + id + ", Nome da Classe: " + className);
    }

    public ObjectNotFoundException(Integer id, String className, Throwable cause) {
        super("Objeto não Encontrado! Parametro: " + id + ", Nome da Classe: " + className, cause);
    }

    public ObjectNotFoundException(String referencia, Fornecedor fornecedor, String className) {
        super("Objeto não Encontrado! Parametros: " + referencia + " " + fornecedor.getNome() + ", Nome da Classe: "
                + className);
    }

    public ObjectNotFoundException(String referencia, Fornecedor fornecedor, String className, Throwable cause) {
        super("Objeto não Encontrado! Parametros: " + referencia + " " + fornecedor.getNome() + ", Nome da Classe: "
                + className);
    }


}
