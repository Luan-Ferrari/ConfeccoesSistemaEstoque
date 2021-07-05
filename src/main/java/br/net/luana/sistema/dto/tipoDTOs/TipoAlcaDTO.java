package br.net.luana.sistema.dto.tipoDTOs;

import br.net.luana.sistema.domain.tipos.TipoAlca;
import org.springframework.stereotype.Component;

@Component
public class TipoAlcaDTO extends TipoDTO<TipoAlca, TipoAlcaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    @Override
    public TipoAlcaDTO makeDTO(TipoAlca entity) {
        super.setId(entity.getId());
        super.setTipo(getTipo());
        return this;
    }

    @Override
    public TipoAlca makeEntityfromDTO(TipoAlcaDTO dto) {
        return super.makeEntityfromDTO(dto);
    }
}
