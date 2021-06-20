package br.net.luana.sistema.resources.corResources;

import br.net.luana.sistema.domain.cores.CorTecido;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import br.net.luana.sistema.dto.corDTOs.CorTecidoDTO;
import br.net.luana.sistema.dto.materiaPrimaDTOs.TecidoDTO;
import br.net.luana.sistema.services.corServices.CorTecidoService;
import br.net.luana.sistema.services.materiaPrimaService.TecidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/corTecido")
public class CorTecidoResourceImpl extends CorResourceImpl<CorTecido, CorTecidoDTO, Integer>
        implements CorTecidoResource {

    private CorTecidoService corTecidoService;

    public CorTecidoResourceImpl(CorTecidoService corTecidoService) { super(corTecidoService);
    }
}
