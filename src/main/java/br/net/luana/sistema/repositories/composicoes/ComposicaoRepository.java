package br.net.luana.sistema.repositories.composicoes;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.repositories.MasterRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposicaoRepository extends MasterRepository<Composicao, Integer> {
}
