package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.CartaoKanBan;
import br.net.luana.sistema.domain.CartaoKanBanHistorico;
import br.net.luana.sistema.domain.CorEntradas;
import br.net.luana.sistema.domain.enums.MotivoBaixaKanBan;
import br.net.luana.sistema.dto.CartaoKanBanDTO;
import br.net.luana.sistema.dto.CartaoKanBanHistoricoDTO;
import br.net.luana.sistema.repositories.CartaoKanBanHistoricoRepository;
import br.net.luana.sistema.services.CartaoKanBanService;
import br.net.luana.sistema.services.CorEntradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cartaoKanBan")
public class CartaoKanBanResourceImpl extends MasterResourceImpl<CartaoKanBan, CartaoKanBanDTO, Integer>
        implements CartaoKanBanResource {

    @Autowired
    CartaoKanBanService cartaoKanBanService;
    @Autowired
    CorEntradasService corEntradasService;
    @Autowired
    CartaoKanBanHistoricoDTO cartaoKanBanHistoricoDTO;
    @Autowired
    CartaoKanBanHistoricoRepository cartaoKanBanHistoricoRepository;

    public CartaoKanBanResourceImpl(CartaoKanBanService cartaoKanBanService) {
        super(cartaoKanBanService);
    }


    @Override
    public ResponseEntity<List<String>> baixaEmLote(CartaoKanBanDTO cartoes) {
        List<Integer> codigos = new ArrayList<>();
        for(CartaoKanBanDTO cartao : cartoes.getCartoesParaBaixar()) {
            codigos.add(cartao.getCodigoCartao());
        }
        List<String> retornos = cartaoKanBanService.baixarCarteosEmLote(codigos, MotivoBaixaKanBan.USO);
        return ResponseEntity.ok().body(retornos);
    }

    @Override
    public ResponseEntity<List<CartaoKanBanHistoricoDTO>> findByCorEntrada(Integer corEntradaId) {
        CorEntradas corEntrada = corEntradasService.findById(corEntradaId);
        List<CartaoKanBanHistorico> lista = cartaoKanBanHistoricoRepository.findByCorEntrada(corEntrada);
        return ResponseEntity.ok().body(cartaoKanBanHistoricoDTO.makeListDTO(lista));
    }

}
