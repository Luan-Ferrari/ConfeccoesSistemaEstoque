package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.MasterDomain;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MasterService <T extends MasterDomain, ID extends Integer> {

    List<T> findAll();
    Page<T> findPage(Integer Page, Integer linesPerPage, String direction, String orderBy);
    T findById(ID entityId);

    T save (T entity);

    T updateById(T entity, ID entityId);

    void deleteById(ID entityId);
}
