package br.net.luana.sistema.resources.tipoResources;

import br.net.luana.sistema.domain.tipos.TipoTecido;
import br.net.luana.sistema.dto.tipoDTOs.TipoTecidoDTO;
import br.net.luana.sistema.services.tipoServices.TipoTecidoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tipoTecido")
public class TipoTecidoResourceImpl extends TipoResourceImpl<TipoTecido, TipoTecidoDTO, Integer>
        implements TipoTecidoResource {

    public TipoTecidoResourceImpl(TipoTecidoService tipoTecidoService) {
        super(tipoTecidoService);
    }
}
