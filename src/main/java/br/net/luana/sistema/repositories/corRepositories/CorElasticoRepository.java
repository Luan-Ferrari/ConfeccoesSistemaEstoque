package br.net.luana.sistema.repositories.corRepositories;

import br.net.luana.sistema.domain.cores.CorElastico;
import org.springframework.stereotype.Repository;

@Repository
public interface CorElasticoRepository extends CorRepository<CorElastico, Integer> {
}
