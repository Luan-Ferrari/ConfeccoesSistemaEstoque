package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.materiasprimas.Bojo;
import br.net.luana.sistema.domain.materiasprimas.Colchete;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import org.springframework.stereotype.Component;

@Component
public class BojoDTO extends MateriaPrimaDTO<Bojo, BojoDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private Integer tipoBojoId;

    public BojoDTO() {
    }

    public BojoDTO(Bojo entity) {
        super(entity);
        this.tipoBojoId = entity.getTipoBojo().getId();
    }

    @Override
    public BojoDTO makeDTO(Bojo entity) {
        return new BojoDTO(entity);
    }

    public Integer getTipoBojoId() {
        return tipoBojoId;
    }

    public void setTipoBojoId(Integer tipoBojoId) {
        this.tipoBojoId = tipoBojoId;
    }
}
