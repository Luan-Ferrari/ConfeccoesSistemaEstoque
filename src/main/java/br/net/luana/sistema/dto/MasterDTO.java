package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.MasterDomain;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Stream;

public interface MasterDTO<T extends MasterDomain, D extends MasterDTOImpl, ID extends Integer> {

    D makeDTO(T entity);

    List<D> makeListDTO(List<T> list);

    Page<D> makePageDTO(Page<T> list);

}
