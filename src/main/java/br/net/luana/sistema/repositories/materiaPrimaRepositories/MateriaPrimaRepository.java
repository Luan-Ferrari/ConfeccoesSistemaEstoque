package br.net.luana.sistema.repositories.materiaPrimaRepositories;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.repositories.MasterRepository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MateriaPrimaRepository<T extends MateriaPrima, ID extends Integer>
        extends MasterRepository<T, ID> {

}
