package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.Contato;
import br.net.luana.sistema.dto.ContatoDTO;
import br.net.luana.sistema.services.ContatoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contato")
public class ContatoResourceImpl extends MasterResourceImpl<Contato, ContatoDTO, Integer>
        implements ContaotResource {

    public ContatoResourceImpl(ContatoService contatoService) {
        super(contatoService);
    }
}
