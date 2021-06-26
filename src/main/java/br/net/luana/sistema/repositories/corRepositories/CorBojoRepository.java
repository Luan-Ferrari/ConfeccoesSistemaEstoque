package br.net.luana.sistema.repositories.corRepositories;

import br.net.luana.sistema.domain.cores.CorBojo;
import br.net.luana.sistema.domain.cores.CorTecido;
import org.springframework.stereotype.Repository;

@Repository
public interface CorBojoRepository extends CorRepository<CorBojo, Integer> {
}
