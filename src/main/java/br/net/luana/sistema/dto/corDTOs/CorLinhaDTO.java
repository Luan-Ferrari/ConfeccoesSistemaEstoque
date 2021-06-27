package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorLinha;
import org.springframework.stereotype.Component;


@Component
public class CorLinhaDTO extends CorDTO<CorLinha, CorLinhaDTO, Integer> {
    private static final long serialVerialUID = 1L;

    private Integer linhaId;

    public CorLinhaDTO() {
    }

    public CorLinhaDTO(CorLinha entity) {
        super(entity);
        this.linhaId = entity.getLinha().getId();
    }

    @Override
    public CorLinhaDTO makeDTO(CorLinha entity) {
        return new CorLinhaDTO(entity);
    }

    public Integer getLinhaId() {
        return linhaId;
    }

    public void setLinhaId(Integer linhaId) {
        this.linhaId = linhaId;
    }
}
