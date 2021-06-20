package br.net.luana.sistema.repositories.tipoRepositories;

import br.net.luana.sistema.domain.tipos.TipoTecido;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTecidoRepository extends TipoRepository<TipoTecido, Integer> {
}
