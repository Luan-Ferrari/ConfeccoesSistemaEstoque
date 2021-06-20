package br.net.luana.sistema.repositories.corRepositories;

import br.net.luana.sistema.domain.cores.CorTecido;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public interface CorTecidoRepository extends CorRepository<CorTecido, Integer> {
}
