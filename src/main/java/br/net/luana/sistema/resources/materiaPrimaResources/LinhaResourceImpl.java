package br.net.luana.sistema.resources.materiaPrimaResources;

import br.net.luana.sistema.domain.materiasprimas.Linha;
import br.net.luana.sistema.dto.materiaPrimaDTOs.LinhaDTO;
import br.net.luana.sistema.services.materiaPrimaService.LinhaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/linha")
public class LinhaResourceImpl extends MateriaPrimaResourceImpl<Linha, LinhaDTO, Integer>
        implements LinhaResource {

    public LinhaResourceImpl(LinhaService linhaService) {
        super(linhaService);
    }
}
