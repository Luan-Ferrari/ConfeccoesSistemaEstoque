package br.net.luana.sistema.resources.corResources;

import br.net.luana.sistema.domain.cores.CorColchete;
import br.net.luana.sistema.dto.corDTOs.CorColcheteDTO;
import br.net.luana.sistema.services.corServices.CorColcheteService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/corColchete")
public class CorColcheteResourceImpl extends CorResourceImpl<CorColchete, CorColcheteDTO, Integer>
        implements CorColcheteResource {

    private CorColcheteService corColcheteService;

    public CorColcheteResourceImpl(CorColcheteService corColcheteService) { super(corColcheteService);
    }
}
