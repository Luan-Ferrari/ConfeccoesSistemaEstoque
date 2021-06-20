package br.net.luana.sistema.repositories.tipoRepositories;

import br.net.luana.sistema.domain.tipos.Tipo;
import br.net.luana.sistema.repositories.MasterRepository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TipoRepository<T extends Tipo, ID extends Integer>
        extends MasterRepository<T, ID> {
}
