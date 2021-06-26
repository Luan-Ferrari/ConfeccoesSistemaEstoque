package br.net.luana.sistema.resources.materiaPrimaResources;

import br.net.luana.sistema.domain.materiasprimas.Bojo;
import br.net.luana.sistema.dto.materiaPrimaDTOs.BojoDTO;
import br.net.luana.sistema.services.materiaPrimaService.BojoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bojo")
public class BojoResourceImpl extends MateriaPrimaResourceImpl<Bojo, BojoDTO, Integer>
        implements BojoResource {

    public BojoResourceImpl(BojoService bojoService) {
        super(bojoService);
    }
}
