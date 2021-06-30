package br.net.luana.sistema.repositories.composicoes;

import br.net.luana.sistema.domain.composicoes.ModoLavar;
import br.net.luana.sistema.repositories.MasterRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModoLavarRepository extends MasterRepository<ModoLavar, Integer> {
}
