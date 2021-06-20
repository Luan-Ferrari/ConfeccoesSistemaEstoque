package br.net.luana.sistema.resources.materiaPrimaResources;

import br.net.luana.sistema.domain.materiasprimas.Colchete;
import br.net.luana.sistema.dto.materiaPrimaDTOs.ColcheteDTO;
import br.net.luana.sistema.services.materiaPrimaService.ColcheteService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colchete")
public class ColcheteResourceImpl extends MateriaPrimaResourceImpl<Colchete, ColcheteDTO, Integer>
        implements ColcheteResource {

    private ColcheteService colcheteService;

    public ColcheteResourceImpl(ColcheteService colcheteService) {
        super(colcheteService);
    }
}
