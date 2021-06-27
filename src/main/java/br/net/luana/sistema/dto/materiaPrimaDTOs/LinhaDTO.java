package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.materiasprimas.Linha;
import org.springframework.stereotype.Component;

@Component
public class LinhaDTO extends MateriaPrimaDTO<Linha, LinhaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private Integer tipoLinhaId;
    private String tipoLinha;

    public LinhaDTO() {
    }

    public LinhaDTO(Linha entity) {
        super(entity);
        this.tipoLinhaId = entity.getTipoLinha().getId();
        this.tipoLinha = entity.getTipoLinha().getTipo();
    }

    @Override
    public LinhaDTO makeDTO(Linha entity) {
        return new LinhaDTO(entity);
    }

    public Integer getTipoLinhaId() {
        return tipoLinhaId;
    }

    public void setTipoLinhaId(Integer tipoLinhaId) {
        this.tipoLinhaId = tipoLinhaId;
    }

    public String getTipoLinha() {
        return tipoLinha;
    }

    public void setTipoLinha(String tipoLinha) {
        this.tipoLinha = tipoLinha;
    }
}
