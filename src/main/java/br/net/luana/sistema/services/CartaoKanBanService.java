package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.CartaoKanBan;
import br.net.luana.sistema.domain.CorEntradas;
import br.net.luana.sistema.domain.cores.Cor;

import java.util.List;

public interface CartaoKanBanService extends MasterService<CartaoKanBan, Integer> {

    public CartaoKanBan findByCodigoCartao (int codigo);

    public List<CartaoKanBan> criarCartoesKanBan (Cor cor, CorEntradas corEntrada);

    public List<String> baixarCarteosEmLote(List<Integer> lista);
}
