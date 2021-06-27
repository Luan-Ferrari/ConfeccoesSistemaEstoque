package br.net.luana.sistema.resources.corResources;

import br.net.luana.sistema.domain.cores.CorElastico;
import br.net.luana.sistema.dto.corDTOs.CorElasticoDTO;
import br.net.luana.sistema.services.corServices.CorElasticoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/corElastico")
public class CorElasticoResourceImpl extends CorResourceImpl<CorElastico, CorElasticoDTO, Integer>
        implements CorElasticoResource {

    public CorElasticoResourceImpl(CorElasticoService corElasticoService) { super(corElasticoService);
    }
}
