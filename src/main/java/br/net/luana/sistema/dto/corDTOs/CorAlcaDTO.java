package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorAlca;
import org.springframework.stereotype.Component;


@Component
public class CorAlcaDTO extends CorDTO<CorAlca, CorAlcaDTO, Integer> {
    private static final long serialVerialUID = 1L;

    private Integer alcaId;

    public CorAlcaDTO() {
    }

    public CorAlcaDTO(CorAlca entity) {
        super(entity);
        this.alcaId = entity.getAlca().getId();
    }

    @Override
    public CorAlcaDTO makeDTO(CorAlca entity) {
        return new CorAlcaDTO(entity);
    }

    public Integer getAlcaId() {
        return alcaId;
    }

    public void setAlcaId(Integer alcaId) {
        this.alcaId = alcaId;
    }
}
