package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.CartaoKanBan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartaoKanBanRepository extends MasterRepository<CartaoKanBan, Integer> {

    List<CartaoKanBan> findByEmUso(Boolean emUso);

    Optional<CartaoKanBan> findByCodigoCartao(Integer codigoCartao);
}
