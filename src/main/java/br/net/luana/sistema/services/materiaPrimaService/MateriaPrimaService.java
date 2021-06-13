package br.net.luana.sistema.services.materiaPrimaService;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.dto.MateriaPrimaDTO;
import br.net.luana.sistema.services.MasterService;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MateriaPrimaService<T extends MateriaPrima, ID extends Integer>
        extends MasterService<T, ID> {

//
//    List<T> findAll();
//    Page<T> findPage(Integer Page, Integer linesPerPage, String direction, String orderBy);
//    T findById(ID entityId);
//
//    T save (T entity);
//
//    T updateById(T entity, ID entityId);
//
//    void deleteById(ID entityId);
}
