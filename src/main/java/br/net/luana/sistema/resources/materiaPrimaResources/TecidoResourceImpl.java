package br.net.luana.sistema.resources.materiaPrimaResources;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import br.net.luana.sistema.dto.materiaPrimaDTOs.TecidoDTO;
import br.net.luana.sistema.services.materiaPrimaService.TecidoService;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tecido")
public class TecidoResourceImpl extends MateriaPrimaResourceImpl<Tecido, TecidoDTO, Integer>
        implements TecidoResource {

    private TecidoService tecidoService;

    public TecidoResourceImpl(TecidoService tecidoService) {
        super(tecidoService);
    }
}
