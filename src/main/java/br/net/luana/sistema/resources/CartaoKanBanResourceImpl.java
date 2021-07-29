package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.CartaoKanBan;
import br.net.luana.sistema.dto.CartaoKanBanDTO;
import br.net.luana.sistema.services.CartaoKanBanService;
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

    public CartaoKanBanResourceImpl(CartaoKanBanService cartaoKanBanService) {
        super(cartaoKanBanService);
    }


    @Override
    public ResponseEntity<List<String>> baixaEmLote(CartaoKanBanDTO cartoes) {
        List<Integer> codigos = new ArrayList<>();
        for(CartaoKanBanDTO cartao : cartoes.getCartoesParaBaixar()) {
            System.out.println(cartao.getCodigoCartao());
            codigos.add(cartao.getCodigoCartao());
        }
        List<String> retornos = cartaoKanBanService.baixarCarteosEmLote(codigos);
        return ResponseEntity.ok().body(retornos);
    }
}
