package br.net.luana.sistema.dto.tipoDTOs;

import br.net.luana.sistema.domain.tipos.Tipo;
import br.net.luana.sistema.domain.tipos.TipoTecido;
import org.springframework.stereotype.Component;

@Component
public class TipoTecidoDTO extends TipoDTO<TipoTecido, TipoTecidoDTO, Integer> {
    private static final long serialVersionUID = 1L;

    public TipoTecidoDTO() {
    }

    public TipoTecidoDTO(Tipo entity) {
        super(entity);
    }

    @Override
    public TipoTecidoDTO makeDTO(TipoTecido entity) {
        return new TipoTecidoDTO(entity);
    }

    @Override
    public TipoTecido makeEntityfromDTO(TipoTecidoDTO dto) {
        return new TipoTecido(dto.getId(), dto.getTipo());
    }
}
