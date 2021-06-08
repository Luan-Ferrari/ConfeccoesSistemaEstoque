package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface MateriaPrimaService<T extends MateriaPrima, ID extends Integer> {


    public abstract List<T> findAll();
    public abstract Page<T> findPage(Integer Page, Integer linesPerPage, String direction, String orderBy);
    public abstract T findById(ID entityId);

    public abstract T save (T entity);

    public abstract T updateById(T entity, ID entityId);

    public abstract void deleteById(ID entityId);
}
