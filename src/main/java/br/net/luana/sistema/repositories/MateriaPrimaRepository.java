package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface MateriaPrimaRepository<T extends MateriaPrima, ID extends Integer>
        extends JpaRepository<T, ID> {

}
