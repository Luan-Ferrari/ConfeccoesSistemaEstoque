package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.CartaoKanBanHistorico;
import br.net.luana.sistema.domain.CorEntradas;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaoKanBanHistoricoRepository extends MasterRepository<CartaoKanBanHistorico, Integer> {

    public abstract List<CartaoKanBanHistorico> findByCorEntrada(CorEntradas corEntradaId);

}
