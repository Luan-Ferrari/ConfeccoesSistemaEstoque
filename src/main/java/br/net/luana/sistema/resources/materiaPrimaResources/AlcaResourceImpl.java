package br.net.luana.sistema.resources.materiaPrimaResources;

import br.net.luana.sistema.domain.materiasprimas.Alca;
import br.net.luana.sistema.dto.materiaPrimaDTOs.AlcaDTO;
import br.net.luana.sistema.services.materiaPrimaService.AlcaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alca")
public class AlcaResourceImpl extends MateriaPrimaResourceImpl<Alca, AlcaDTO, Integer>
        implements AlcaResource {

    public AlcaResourceImpl(AlcaService alcaService) {
        super(alcaService);
    }
}
