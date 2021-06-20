package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorTecido;

import org.springframework.stereotype.Component;


@Component
public class CorTecidoDTO extends CorDTO<CorTecido, CorTecidoDTO, Integer> {
    private static final long serialVerialUID = 1L;

    private Integer composicaoId;
    private Integer tecidoId;

    public CorTecidoDTO() {
    }

    public CorTecidoDTO(CorTecido entity) {
        super(entity);
        this.composicaoId = entity.getComposicao().getId();
        this.tecidoId = entity.getTecido().getId();
    }

    @Override
    public CorTecidoDTO makeDTO(CorTecido entity) {
        return new CorTecidoDTO(entity);
    }

    public Integer getComposicaoId() {
        return composicaoId;
    }

    public void setComposicaoId(Integer composicaoId) {
        this.composicaoId = composicaoId;
    }

    public Integer getTecidoId() {
        return tecidoId;
    }

    public void setTecidoId(Integer tecidoId) {
        this.tecidoId = tecidoId;
    }
}
