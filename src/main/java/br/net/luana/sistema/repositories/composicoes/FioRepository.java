package br.net.luana.sistema.repositories.composicoes;

import br.net.luana.sistema.domain.composicoes.Fio;
import br.net.luana.sistema.repositories.MasterRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FioRepository extends MasterRepository<Fio, Integer> {

    Fio findByNome (String nome);
}
