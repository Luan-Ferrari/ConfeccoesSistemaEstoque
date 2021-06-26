package br.net.luana.sistema.resources.corResources;

import br.net.luana.sistema.domain.cores.CorBojo;
import br.net.luana.sistema.dto.corDTOs.CorBojoDTO;
import br.net.luana.sistema.services.corServices.CorBojoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/corBojo")
public class CorBojoResourceImpl extends CorResourceImpl<CorBojo, CorBojoDTO, Integer>
        implements CorBojoResource {

    public CorBojoResourceImpl(CorBojoService corBojoService) { super(corBojoService);
    }
}
