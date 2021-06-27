package br.net.luana.sistema.resources.tipoResources;

import br.net.luana.sistema.domain.tipos.TipoAlca;
import br.net.luana.sistema.dto.tipoDTOs.TipoAlcaDTO;
import br.net.luana.sistema.services.tipoServices.TipoAlcaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tipoAlca")
public class TipoAlcaResourceImpl extends TipoResourceImpl<TipoAlca, TipoAlcaDTO, Integer>
        implements TipoAlcaResource {

    public TipoAlcaResourceImpl(TipoAlcaService tipoAlcaService) {
        super(tipoAlcaService);
    }
}
