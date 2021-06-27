package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.materiasprimas.Alca;
import org.springframework.stereotype.Component;

@Component
public class AlcaDTO extends MateriaPrimaDTO<Alca, AlcaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private Integer tipoAlcaId;
    private String tipoAlca;

    public AlcaDTO() {
    }

    public AlcaDTO(Alca entity) {
        super(entity);
        this.tipoAlcaId = entity.getTipoAlca().getId();
        this.tipoAlca = entity.getTipoAlca().getTipo();
    }

    @Override
    public AlcaDTO makeDTO(Alca entity) {
        return new AlcaDTO(entity);
    }

    public Integer getTipoAlcaId() {
        return tipoAlcaId;
    }

    public void setTipoAlcaId(Integer tipoAlcaId) {
        this.tipoAlcaId = tipoAlcaId;
    }

    public String getTipoAlca() {
        return tipoAlca;
    }

    public void setTipoAlca(String tipoAlca) {
        this.tipoAlca = tipoAlca;
    }
}
