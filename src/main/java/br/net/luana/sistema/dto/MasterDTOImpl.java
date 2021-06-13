package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.MasterDomain;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MasterDTOImpl<T extends MasterDomain, D extends MasterDTOImpl, ID extends Integer>
        implements MasterDTO<T, D, ID>{

    private D DTO;

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public D makeDTO(T entity) {
        return null;
    }

    @Override
    public List<D> makeListDTO(List<T> list) {
        List<D> listDto = new ArrayList<>();
        for(T entity : list){
            listDto.add(makeDTO(entity));
        }
        return listDto;
    }

}
