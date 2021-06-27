package br.net.luana.sistema.resources.tipoResources;

import br.net.luana.sistema.domain.tipos.TipoRenda;
import br.net.luana.sistema.dto.tipoDTOs.TipoRendaDTO;
import br.net.luana.sistema.services.tipoServices.TipoRendaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tipoRenda")
public class TipoRendaResourceImpl extends TipoResourceImpl<TipoRenda, TipoRendaDTO, Integer>
        implements TipoRendaResource {

    public TipoRendaResourceImpl(TipoRendaService tipoRendaService) {
        super(tipoRendaService);
    }
}
