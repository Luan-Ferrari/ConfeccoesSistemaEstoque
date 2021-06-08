package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;

public class DTOConstructorImpl<D extends MateriaPrimaDTO, T extends MateriaPrima>
        implements DTOConstructor<D, T>{

    private MateriaPrimaDTO materiaPrimaDTO;

    public DTOConstructorImpl(MateriaPrimaDTO materiaPrimaDTO) {
        this.materiaPrimaDTO = materiaPrimaDTO;
    }

    @Override
    public D fromDto(T object) {

    }
}
