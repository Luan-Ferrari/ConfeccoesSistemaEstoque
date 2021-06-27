package br.net.luana.sistema.resources.corResources;

import br.net.luana.sistema.domain.cores.CorAlca;
import br.net.luana.sistema.dto.corDTOs.CorAlcaDTO;
import br.net.luana.sistema.services.corServices.CorAlcaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/corAlca")
public class CorAlcaResourceImpl extends CorResourceImpl<CorAlca, CorAlcaDTO, Integer>
        implements CorAlcaResource {

    public CorAlcaResourceImpl(CorAlcaService corAlcaService) { super(corAlcaService);
    }
}
