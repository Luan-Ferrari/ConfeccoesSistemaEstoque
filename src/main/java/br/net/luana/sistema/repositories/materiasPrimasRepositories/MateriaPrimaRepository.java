package br.net.luana.sistema.repositories.materiasPrimasRepositories;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MateriaPrimaRepository<T extends MateriaPrima, ID extends Integer>
        extends JpaRepository<T, ID> {

}
