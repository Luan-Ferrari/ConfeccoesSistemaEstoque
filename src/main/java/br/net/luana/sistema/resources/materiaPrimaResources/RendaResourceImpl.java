package br.net.luana.sistema.resources.materiaPrimaResources;

import br.net.luana.sistema.domain.materiasprimas.Renda;
import br.net.luana.sistema.dto.materiaPrimaDTOs.RendaDTO;
import br.net.luana.sistema.services.materiaPrimaService.RendaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/renda")
public class RendaResourceImpl extends MateriaPrimaResourceImpl<Renda, RendaDTO, Integer>
        implements RendaResource {

    public RendaResourceImpl(RendaService rendaService) {
        super(rendaService);
    }
}
