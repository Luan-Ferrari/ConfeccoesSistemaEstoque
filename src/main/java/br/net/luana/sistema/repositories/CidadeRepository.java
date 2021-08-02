package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.Cidade;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends MasterRepository<Cidade, Integer> {
}
