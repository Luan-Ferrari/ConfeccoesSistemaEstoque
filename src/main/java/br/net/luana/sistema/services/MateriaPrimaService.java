package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.dto.MateriaPrimaDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MateriaPrimaService<T extends MateriaPrima, D extends MateriaPrimaDTO, ID extends Integer> {


    List<T> findAll();
    Page<T> findPage(Integer Page, Integer linesPerPage, String direction, String orderBy);
    T findById(ID entityId);

    T save (T entity);

    T updateById(T entity, ID entityId);

    void deleteById(ID entityId);

    D toDto(T entity);
}
