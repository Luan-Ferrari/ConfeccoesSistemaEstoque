package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.Contato;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends MasterRepository<Contato, Integer> {
}
