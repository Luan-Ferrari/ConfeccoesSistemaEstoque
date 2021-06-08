package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.materiasprimas.Colchete;
import br.net.luana.sistema.services.ColcheteService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colchete")
public class ColcheteResourceImpl extends MateriaPrimaResourceImpl<Colchete, Integer>
        implements ColcheteResource {

    private ColcheteService colcheteService;

    public ColcheteResourceImpl(ColcheteService colcheteService) {
        super(colcheteService);
    }
}
