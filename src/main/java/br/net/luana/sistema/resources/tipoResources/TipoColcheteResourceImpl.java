package br.net.luana.sistema.resources.tipoResources;

import br.net.luana.sistema.domain.tipos.TipoColchete;
import br.net.luana.sistema.domain.tipos.TipoTecido;
import br.net.luana.sistema.dto.tipoDTOs.TipoColcheteDTO;
import br.net.luana.sistema.dto.tipoDTOs.TipoTecidoDTO;
import br.net.luana.sistema.services.tipoServices.TipoColcheteService;
import br.net.luana.sistema.services.tipoServices.TipoTecidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tipoColchete")
public class TipoColcheteResourceImpl extends TipoResourceImpl<TipoColchete, TipoColcheteDTO, Integer>
        implements TipoColcheteResource {

    public TipoColcheteResourceImpl(TipoColcheteService tipoColcheteService) {
        super(tipoColcheteService);
    }
}
