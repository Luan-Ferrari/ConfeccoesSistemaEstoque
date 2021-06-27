package br.net.luana.sistema.resources.corResources;

import br.net.luana.sistema.domain.cores.CorLinha;
import br.net.luana.sistema.dto.corDTOs.CorLinhaDTO;
import br.net.luana.sistema.services.corServices.CorLinhaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/corLinha")
public class CorLinhaResourceImpl extends CorResourceImpl<CorLinha, CorLinhaDTO, Integer>
        implements CorLinhaResource {

    public CorLinhaResourceImpl(CorLinhaService corLinhaService) { super(corLinhaService);
    }
}
