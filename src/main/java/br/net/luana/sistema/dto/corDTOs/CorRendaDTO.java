package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorRenda;
import org.springframework.stereotype.Component;


@Component
public class CorRendaDTO extends CorDTO<CorRenda, CorRendaDTO, Integer> {
    private static final long serialVerialUID = 1L;

    private Integer rendaId;

    public CorRendaDTO() {
    }

    public CorRendaDTO(CorRenda entity) {
        super(entity);
        this.rendaId = entity.getRenda().getId();
    }

    @Override
    public CorRendaDTO makeDTO(CorRenda entity) {
        return new CorRendaDTO(entity);
    }

    public Integer getRendaId() {
        return rendaId;
    }

    public void setRendaId(Integer rendaId) {
        this.rendaId = rendaId;
    }
}
