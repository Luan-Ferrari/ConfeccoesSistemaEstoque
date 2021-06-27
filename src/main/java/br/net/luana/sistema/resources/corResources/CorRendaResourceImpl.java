package br.net.luana.sistema.resources.corResources;

import br.net.luana.sistema.domain.cores.CorRenda;
import br.net.luana.sistema.dto.corDTOs.CorRendaDTO;
import br.net.luana.sistema.services.corServices.CorRendaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/corRenda")
public class CorRendaResourceImpl extends CorResourceImpl<CorRenda, CorRendaDTO, Integer>
        implements CorRendaResource {

    public CorRendaResourceImpl(CorRendaService corRendaService) { super(corRendaService);
    }
}
