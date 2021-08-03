package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.Contato;
import br.net.luana.sistema.dto.ContatoDTO;
import br.net.luana.sistema.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contato")
public class ContatoResourceImpl extends MasterResourceImpl<Contato, ContatoDTO, Integer>
        implements ContatoResource {

    @Autowired
    private ContatoService contatoService;

    public ContatoResourceImpl(ContatoService contatoService) {
        super(contatoService);
    }

    @Override
    public ResponseEntity<Void> updateFornecedor(Integer entityId, Integer fornecedorId) {
        contatoService.adicionarFornecedor(entityId, fornecedorId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteFornecedor(Integer entityId, Integer fornecedorId) {
        contatoService.excluirFornecedor(entityId, fornecedorId);
        return ResponseEntity.noContent().build();
    }
}
