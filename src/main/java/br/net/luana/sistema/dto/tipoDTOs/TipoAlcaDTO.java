package br.net.luana.sistema.dto.tipoDTOs;

import br.net.luana.sistema.domain.tipos.TipoAlca;
import org.springframework.stereotype.Component;

@Component
public class TipoAlcaDTO extends TipoDTO<TipoAlca, TipoAlcaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    public TipoAlcaDTO() {
    }

    public TipoAlcaDTO(TipoAlca entity) {
        super(entity);
    }

    @Override
    public TipoAlcaDTO makeDTO(TipoAlca entity) {
        return new TipoAlcaDTO(entity);
    }

    @Override
    public TipoAlca makeEntityfromDTO(TipoAlcaDTO dto) {
        return new TipoAlca(dto.getId(), dto.getTipo());
    }
}
