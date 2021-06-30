package br.net.luana.sistema.resources.composicaoResources;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.dto.composicoesDTOs.ComposicaoDTO;
import br.net.luana.sistema.resources.MasterResourceImpl;
import br.net.luana.sistema.services.composicaoServices.ComposicaoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/composicao")
public class ComposicaoResourceImpl extends MasterResourceImpl<Composicao, ComposicaoDTO, Integer>
        implements ComposicaoResource {


    public ComposicaoResourceImpl(ComposicaoService composicaoService) {
        super(composicaoService);
    }
}
