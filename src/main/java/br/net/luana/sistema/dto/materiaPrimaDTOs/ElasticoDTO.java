package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.materiasprimas.Elastico;
import org.springframework.stereotype.Component;

@Component
public class ElasticoDTO extends MateriaPrimaDTO<Elastico, ElasticoDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private Integer tipoElasticoId;
    private String tipoElastico;

    public ElasticoDTO() {
    }

    public ElasticoDTO(Elastico entity) {
        super(entity);
        this.tipoElasticoId = entity.getTipoElastico().getId();
        this.tipoElastico = entity.getTipoElastico().getTipo();
    }

    @Override
    public ElasticoDTO makeDTO(Elastico entity) {
        return new ElasticoDTO(entity);
    }

    public Integer getTipoElasticoId() {
        return tipoElasticoId;
    }

    public void setTipoElasticoId(Integer tipoElasticoId) {
        this.tipoElasticoId = tipoElasticoId;
    }

    public String getTipoElastico() {
        return tipoElastico;
    }

    public void setTipoElastico(String tipoElastico) {
        this.tipoElastico = tipoElastico;
    }
}
