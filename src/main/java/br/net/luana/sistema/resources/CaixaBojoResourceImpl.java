package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.CaixaBojo;
import br.net.luana.sistema.dto.CaixaBojoDTO;
import br.net.luana.sistema.services.CaixaBojoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caixaBojo")
public class CaixaBojoResourceImpl extends MasterResourceImpl<CaixaBojo, CaixaBojoDTO, Integer>
        implements CaixaBojoResource {


    public CaixaBojoResourceImpl(CaixaBojoService caixaBojoService) {
        super(caixaBojoService);
    }
}
