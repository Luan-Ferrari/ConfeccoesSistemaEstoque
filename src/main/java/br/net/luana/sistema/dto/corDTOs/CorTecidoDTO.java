package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorTecido;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.composicoesDTOs.ComposicaoDTO;
import br.net.luana.sistema.dto.materiaPrimaDTOs.TecidoDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
public class CorTecidoDTO extends CorDTO<CorTecido, CorTecidoDTO, Integer> {
    private static final long serialVerialUID = 1L;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private TecidoDTO tecido = new TecidoDTO();

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private ComposicaoDTO composicao = new ComposicaoDTO();

    public CorTecidoDTO() {
    }

    public CorTecidoDTO(CorTecido entity) {
        super(entity);
        this.tecido = tecido.makeDTO(entity.getTecido());
        this.composicao = composicao.makeDTO(entity.getComposicao());
    }

    @Override
    public CorTecidoDTO makeDTO(CorTecido entity) {
        return new CorTecidoDTO(entity);
    }

    @Override
    public CorTecido makeEntityfromDTO(CorTecidoDTO dto) {
        return new CorTecido(dto.getId(), dto.getReferenciaNaFabrica(), dto.getNome(), dto.getObservacoes(),
                dto.getQuantidadeEstoque(), tecido.makeEntityfromDTO(dto.getTecido()),
                composicao.makeEntityfromDTO(dto.getComposicao()));
    }

    public TecidoDTO getTecido() {
        return tecido;
    }

    public void setTecido(TecidoDTO tecido) {
        this.tecido = tecido;
    }

    public ComposicaoDTO getComposicao() {
        return composicao;
    }

    public void setComposicao(ComposicaoDTO composicao) {
        this.composicao = composicao;
    }
}
