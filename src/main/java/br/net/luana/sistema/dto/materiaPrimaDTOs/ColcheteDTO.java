package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.materiasprimas.Colchete;
import org.springframework.stereotype.Component;

@Component
public class ColcheteDTO extends MateriaPrimaDTO<Colchete, ColcheteDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private Integer tipoColcheteId;
    private String tipoColchete;

    public ColcheteDTO() {
    }

    public ColcheteDTO(Colchete entity) {
        super(entity);
        this.tipoColcheteId = entity.getTipoColchete().getId();
        this.tipoColchete = entity.getTipoColchete().getTipo();
    }

    @Override
    public ColcheteDTO makeDTO(Colchete entity) {
        return new ColcheteDTO(entity);
    }

    public Integer getTipoColcheteId() {
        return tipoColcheteId;
    }

    public void setTipoColcheteId(Integer tipoColcheteId) {
        this.tipoColcheteId = tipoColcheteId;
    }

    public String getTipoColchete() {
        return tipoColchete;
    }

    public void setTipoColchete(String tipoColchete) {
        this.tipoColchete = tipoColchete;
    }
}
