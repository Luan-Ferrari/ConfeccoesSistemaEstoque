package br.net.luana.sistema.resources.materiaPrimaResources;

import br.net.luana.sistema.domain.materiasprimas.Elastico;
import br.net.luana.sistema.dto.materiaPrimaDTOs.ElasticoDTO;
import br.net.luana.sistema.services.materiaPrimaService.ElasticoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elastico")
public class ElasticoResourceImpl extends MateriaPrimaResourceImpl<Elastico, ElasticoDTO, Integer>
        implements ElasticoResource {

    public ElasticoResourceImpl(ElasticoService elasticoService) {
        super(elasticoService);
    }
}
