package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorElastico;
import org.springframework.stereotype.Component;


@Component
public class CorElasticoDTO extends CorDTO<CorElastico, CorElasticoDTO, Integer> {
    private static final long serialVerialUID = 1L;

    private Integer elasticoId;

    public CorElasticoDTO() {
    }

    public CorElasticoDTO(CorElastico entity) {
        super(entity);
        this.elasticoId = entity.getElastico().getId();
    }

    @Override
    public CorElasticoDTO makeDTO(CorElastico entity) {
        return new CorElasticoDTO(entity);
    }

    public Integer getElasticoId() {
        return elasticoId;
    }

    public void setElasticoId(Integer elasticoId) {
        this.elasticoId = elasticoId;
    }
}
