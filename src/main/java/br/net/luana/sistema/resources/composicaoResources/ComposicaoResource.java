package br.net.luana.sistema.resources.composicaoResources;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.dto.composicoesDTOs.ComposicaoDTO;
import br.net.luana.sistema.resources.MasterResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ComposicaoResource extends MasterResource<Composicao, ComposicaoDTO, Integer> {

    @GetMapping("/verificar")
    ResponseEntity<List<ComposicaoDTO>> verificaDuplicidade(@RequestBody ComposicaoDTO composicao);
}
