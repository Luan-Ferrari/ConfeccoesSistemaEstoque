package br.net.luana.sistema.resources.tipoResources;

import br.net.luana.sistema.domain.tipos.TipoBojo;
import br.net.luana.sistema.dto.tipoDTOs.TipoBojoDTO;
import br.net.luana.sistema.services.tipoServices.TipoBojoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tipoBojo")
public class TipoBojoResourceImpl extends TipoResourceImpl<TipoBojo, TipoBojoDTO, Integer>
        implements TipoBojoResource {

    public TipoBojoResourceImpl(TipoBojoService tipoBojoService) {
        super(tipoBojoService);
    }
}
