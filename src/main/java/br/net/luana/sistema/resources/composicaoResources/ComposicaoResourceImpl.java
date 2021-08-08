package br.net.luana.sistema.resources.composicaoResources;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.dto.composicoesDTOs.ComposicaoDTO;
import br.net.luana.sistema.resources.MasterResourceImpl;
import br.net.luana.sistema.services.composicaoServices.ComposicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/composicao")
public class ComposicaoResourceImpl extends MasterResourceImpl<Composicao, ComposicaoDTO, Integer>
        implements ComposicaoResource {

    @Autowired
    ComposicaoService composicaoService;


    public ComposicaoResourceImpl(ComposicaoService composicaoService) {
        super(composicaoService);
    }

    @Override
    public ResponseEntity<List<ComposicaoDTO>> verificaDuplicidade(ComposicaoDTO composicao) {
        List<Composicao> list = composicaoService.verificaDuplicidade(composicao.makeEntityfromDTO(composicao));
        return ResponseEntity.ok().body(composicao.makeListDTO(list));
    }
}
