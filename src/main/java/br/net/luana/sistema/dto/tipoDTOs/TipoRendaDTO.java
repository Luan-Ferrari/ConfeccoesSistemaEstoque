package br.net.luana.sistema.dto.tipoDTOs;

import br.net.luana.sistema.domain.tipos.TipoRenda;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.composicoesDTOs.ComposicaoDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class TipoRendaDTO extends TipoDTO<TipoRenda, TipoRendaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private ComposicaoDTO composicao = new ComposicaoDTO();

    public TipoRendaDTO() {

    }

    public TipoRendaDTO(TipoRenda entity) {
        super(entity);
        this.composicao = composicao.makeDTO(entity.getComposicao());
    }

    @Override
    public TipoRendaDTO makeDTO(TipoRenda entity) { return new TipoRendaDTO(entity);  }

    @Override
    public TipoRenda makeEntityfromDTO(TipoRendaDTO dto) {
        return new TipoRenda(dto.getId(), dto.getTipo(), composicao.makeEntityfromDTO(dto.getComposicao()));
    }

    public ComposicaoDTO getComposicao() {
        return composicao;
    }

    public void setComposicao(ComposicaoDTO composicao) {
        this.composicao = composicao;
    }
}
