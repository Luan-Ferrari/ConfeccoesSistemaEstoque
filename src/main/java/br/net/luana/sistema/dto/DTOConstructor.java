package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;

public interface DTOConstructor <D extends MateriaPrimaDTO, T extends MateriaPrima> {

    D fromDto(T object);
}
