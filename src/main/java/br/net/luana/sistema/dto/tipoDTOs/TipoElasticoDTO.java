package br.net.luana.sistema.dto.tipoDTOs;

import br.net.luana.sistema.domain.tipos.TipoElastico;
import org.springframework.stereotype.Component;

@Component
public class TipoElasticoDTO extends TipoDTO<TipoElastico, TipoElasticoDTO, Integer> {
    private static final long serialVersionUID = 1L;

    public TipoElasticoDTO() {
    }

    public TipoElasticoDTO(TipoElastico entity) {
        super(entity);
    }

    @Override
    public TipoElasticoDTO makeDTO(TipoElastico entity) {
        return new TipoElasticoDTO(entity);
    }

    @Override
    public TipoElastico makeEntityfromDTO(TipoElasticoDTO dto) {
        return new TipoElastico(dto.getId(), dto.getTipo());
    }
}
