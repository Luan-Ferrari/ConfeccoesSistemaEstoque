package br.net.luana.sistema.repositories.coresRepositories;

import br.net.luana.sistema.domain.cores.CorTecido;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository("corTecidoRepository")
public interface CorTecidoRepository extends CorRepository<CorTecido, Integer> {
}
