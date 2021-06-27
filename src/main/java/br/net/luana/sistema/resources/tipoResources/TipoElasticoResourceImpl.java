package br.net.luana.sistema.resources.tipoResources;

import br.net.luana.sistema.domain.tipos.TipoElastico;
import br.net.luana.sistema.dto.tipoDTOs.TipoElasticoDTO;
import br.net.luana.sistema.services.tipoServices.TipoElasticoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tipoElastico")
public class TipoElasticoResourceImpl extends TipoResourceImpl<TipoElastico, TipoElasticoDTO, Integer>
        implements TipoElasticoResource {

    public TipoElasticoResourceImpl(TipoElasticoService tipoElasticoService) {
        super(tipoElasticoService);
    }
}
