package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.materiasprimas.Renda;
import org.springframework.stereotype.Component;

@Component
public class RendaDTO extends MateriaPrimaDTO<Renda, RendaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private Integer tipoRendaId;
    private String tipoRenda;

    public RendaDTO() {
    }

    public RendaDTO(Renda entity) {
        super(entity);
        this.tipoRendaId = entity.getTipoRenda().getId();
        this.tipoRenda = entity.getTipoRenda().getTipo();
    }

    @Override
    public RendaDTO makeDTO(Renda entity) {
        return new RendaDTO(entity);
    }

    public Integer getTipoRendaId() {
        return tipoRendaId;
    }

    public void setTipoRendaId(Integer tipoRendaId) {
        this.tipoRendaId = tipoRendaId;
    }

    public String getTipoRenda() {
        return tipoRenda;
    }

    public void setTipoRenda(String tipoRenda) {
        this.tipoRenda = tipoRenda;
    }
}
