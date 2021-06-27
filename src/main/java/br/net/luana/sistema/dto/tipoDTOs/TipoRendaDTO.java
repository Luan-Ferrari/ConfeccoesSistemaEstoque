package br.net.luana.sistema.dto.tipoDTOs;

import br.net.luana.sistema.domain.tipos.TipoRenda;
import org.springframework.stereotype.Component;

@Component
public class TipoRendaDTO extends TipoDTO<TipoRenda, TipoRendaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private Integer composicaoId;

    public TipoRendaDTO() {

    }

    public TipoRendaDTO(TipoRenda entity) {
        super(entity);
        this.composicaoId = entity.getComposicao().getId();
    }

    @Override
    public TipoRendaDTO makeDTO(TipoRenda entity) { return new TipoRendaDTO(entity);  }

    public Integer getComposicaoId() {
        return composicaoId;
    }

    public void setComposicaoId(Integer composicaoId) {
        this.composicaoId = composicaoId;
    }
}
