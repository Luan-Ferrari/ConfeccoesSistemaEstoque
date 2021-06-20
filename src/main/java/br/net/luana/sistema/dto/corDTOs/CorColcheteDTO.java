package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorColchete;
import br.net.luana.sistema.domain.cores.CorTecido;
import org.springframework.stereotype.Component;


@Component
public class CorColcheteDTO extends CorDTO<CorColchete, CorColcheteDTO, Integer> {
    private static final long serialVerialUID = 1L;

    private Integer colcheteId;

    public CorColcheteDTO() {
    }

    public CorColcheteDTO(CorColchete entity) {
        super(entity);
        this.colcheteId = entity.getColchete().getId();
    }

    @Override
    public CorColcheteDTO makeDTO(CorColchete entity) {
        return new CorColcheteDTO(entity);
    }

    public Integer getColcheteId() {
        return colcheteId;
    }

    public void setColcheteId(Integer colcheteId) {
        this.colcheteId = colcheteId;
    }
}
