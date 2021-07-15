package br.net.luana.sistema.dto.tipoDTOs;

import br.net.luana.sistema.domain.tipos.TipoColchete;
import org.springframework.stereotype.Component;

@Component
public class TipoColcheteDTO extends TipoDTO<TipoColchete, TipoColcheteDTO, Integer> {
    private static final long serialVersionUID = 1L;

    public TipoColcheteDTO() {
    }

    public TipoColcheteDTO(TipoColchete entity) {
        super(entity);
    }

    @Override
    public TipoColcheteDTO makeDTO(TipoColchete entity) {
        return new TipoColcheteDTO(entity);
    }

    @Override
    public TipoColchete makeEntityfromDTO(TipoColcheteDTO dto) {
        return new TipoColchete(dto.getId(), dto.getTipo());
    }
}
