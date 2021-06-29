package br.net.luana.sistema.repositories.composicoes;

import br.net.luana.sistema.domain.composicoes.ComposicaoFio;
import br.net.luana.sistema.repositories.MasterRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposicaoFioRepository extends MasterRepository<ComposicaoFio, Integer> {
}
