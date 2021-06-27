package br.net.luana.sistema.resources.tipoResources;

import br.net.luana.sistema.domain.tipos.TipoLinha;
import br.net.luana.sistema.dto.tipoDTOs.TipoLinhaDTO;
import br.net.luana.sistema.services.tipoServices.TipoLinhaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tipoLinha")
public class TipoLinhaResourceImpl extends TipoResourceImpl<TipoLinha, TipoLinhaDTO, Integer>
        implements TipoLinhaResource {

    public TipoLinhaResourceImpl(TipoLinhaService tipoLinhaService) {
        super(tipoLinhaService);
    }
}
