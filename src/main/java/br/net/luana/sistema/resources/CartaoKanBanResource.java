package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.CartaoKanBan;
import br.net.luana.sistema.dto.CartaoKanBanDTO;
import br.net.luana.sistema.dto.CartaoKanBanHistoricoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CartaoKanBanResource extends MasterResource<CartaoKanBan, CartaoKanBanDTO, Integer> {

    @PatchMapping("/baixaEmLote")
    public abstract ResponseEntity<List<String>> baixaEmLote(@RequestBody CartaoKanBanDTO cartoes);

    @GetMapping("/historico/{corEntradaId}")
    public abstract ResponseEntity<List<CartaoKanBanHistoricoDTO>> findByCorEntrada(@PathVariable Integer corEntradaId);
}
