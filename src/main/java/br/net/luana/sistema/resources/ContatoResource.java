package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.Contato;
import br.net.luana.sistema.dto.ContatoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ContatoResource extends MasterResource<Contato, ContatoDTO, Integer> {

    @PatchMapping("/{entityId}/fornecedor/{fornecedorId}")
    public abstract ResponseEntity<Void> updateFornecedor(@PathVariable Integer entityId,
                                                @PathVariable Integer fornecedorId);

    @DeleteMapping("/{entityId}/fornecedor/{fornecedorId}")
    public abstract ResponseEntity<Void> deleteFornecedor(@PathVariable Integer entityId,
                                                @PathVariable Integer fornecedorId);
}
