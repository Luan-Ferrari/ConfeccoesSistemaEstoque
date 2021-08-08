package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.Colecao;
import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.dto.ColecaoDTO;
import br.net.luana.sistema.dto.corDTOs.CorDTO;
import br.net.luana.sistema.services.ColecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/colecao")
public class ColecaoResourceImpl extends MasterResourceImpl<Colecao, ColecaoDTO, Integer>
        implements ColecaoResource {

    @Autowired
    private ColecaoService colecaoService;

    private CorDTO corDTO = new CorDTO();

    public ColecaoResourceImpl(ColecaoService colecaoService) {
        super(colecaoService);
    }

    @Override
    public ResponseEntity<Void> adicionar(ColecaoDTO entity, Integer entityId) {
        List<Cor> cores = new ArrayList<>();
        for (CorDTO corDTO : entity.getCores()) {
            cores.add(corDTO.makeEntityfromDTO(corDTO));
        }
        colecaoService.adicionarItensColecao(entityId, cores, entity.getNumeros());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> excluir(ColecaoDTO entity, Integer entityId) {
        List<Cor> cores = new ArrayList<>();
        for(CorDTO corDTO : entity.getCores()) {
            cores.add(corDTO.makeEntityfromDTO(corDTO));
        }
        colecaoService.excluirItensColecao(entityId, cores);
        return ResponseEntity.noContent().build();
    }


}
