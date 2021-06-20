package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.CorEntradas;
import br.net.luana.sistema.dto.CorEntradasDTO;
import br.net.luana.sistema.services.CorEntradasService;
import br.net.luana.sistema.services.MasterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/corEntradas")
public class CorEntradasResourceImpl extends MasterResourceImpl<CorEntradas, CorEntradasDTO, Integer>
        implements CorEntradasResource {


    public CorEntradasResourceImpl(CorEntradasService corEntradasService) {
        super(corEntradasService);
    }
}
