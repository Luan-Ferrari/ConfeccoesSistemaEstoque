package br.net.luana.sistema.repositories.tipoRepositories;

import br.net.luana.sistema.domain.tipos.TipoElastico;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoElasticoRepository extends TipoRepository<TipoElastico, Integer> {
}
