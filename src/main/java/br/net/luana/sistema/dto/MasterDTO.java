package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.MasterDomain;

import java.util.List;

public interface MasterDTO<T extends MasterDomain, D extends MasterDTOImpl, ID extends Integer> {

    Integer getId();

    D makeDTO(T entity);

    List<D> makeListDTO(List<T> list);

}
