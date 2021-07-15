package br.net.luana.sistema.dto.tipoDTOs;

import br.net.luana.sistema.domain.tipos.TipoLinha;
import org.springframework.stereotype.Component;

@Component
public class TipoLinhaDTO extends TipoDTO<TipoLinha, TipoLinhaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    public TipoLinhaDTO() {
    }

    public TipoLinhaDTO(TipoLinha entity) {
        super(entity);
    }

    @Override
    public TipoLinhaDTO makeDTO(TipoLinha entity) {
        return new TipoLinhaDTO(entity);
    }

    @Override
    public TipoLinha makeEntityfromDTO(TipoLinhaDTO dto) {
        return new TipoLinha(dto.getId(), dto.getTipo());
    }
}
