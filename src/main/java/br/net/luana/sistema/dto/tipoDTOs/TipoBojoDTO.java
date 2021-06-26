package br.net.luana.sistema.dto.tipoDTOs;

import br.net.luana.sistema.domain.tipos.TipoBojo;
import org.springframework.stereotype.Component;

@Component
public class TipoBojoDTO extends TipoDTO<TipoBojo, TipoBojoDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private String tamanho;
    private Integer composicaoId;

    public TipoBojoDTO() {

    }

    public TipoBojoDTO(TipoBojo entity) {
        super(entity);
        this.tamanho = entity.getTamanho().getDescricao();
        this.composicaoId = entity.getComposicao().getId();
    }

    @Override
    public TipoBojoDTO makeDTO(TipoBojo entity) {
        return new TipoBojoDTO(entity);
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
