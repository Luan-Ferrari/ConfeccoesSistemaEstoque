package br.net.luana.sistema.dto.tipoDTOs;

import br.net.luana.sistema.domain.enums.Tamanho;
import br.net.luana.sistema.domain.tipos.TipoBojo;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.composicoesDTOs.ComposicaoDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class TipoBojoDTO extends TipoDTO<TipoBojo, TipoBojoDTO, Integer> {
    private static final long serialVersionUID = 1L;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private Integer tamanho;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private ComposicaoDTO composicao = new ComposicaoDTO();

    public TipoBojoDTO() {

    }

    public TipoBojoDTO(TipoBojo entity) {
        super(entity);
        this.tamanho = (entity.getTamanho() == null) ? null : entity.getTamanho().getCodigo();
        this.composicao = composicao.makeDTO(entity.getComposicao());
    }

    @Override
    public TipoBojoDTO makeDTO(TipoBojo entity) {
        return new TipoBojoDTO(entity);
    }

    @Override
    public TipoBojo makeEntityfromDTO(TipoBojoDTO dto) {
        return new TipoBojo(dto.getId(), dto.getTipo(), Tamanho.toEnum(dto.getTamanho()),
                composicao.makeEntityfromDTO(dto.getComposicao()));
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public ComposicaoDTO getComposicao() {
        return composicao;
    }

    public void setComposicao(ComposicaoDTO composicao) {
        this.composicao = composicao;
    }
}
