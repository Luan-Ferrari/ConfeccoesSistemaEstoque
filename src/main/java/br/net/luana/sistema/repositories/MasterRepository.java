package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.MasterDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MasterRepository <T extends MasterDomain, ID extends Integer>
        extends JpaRepository<T, ID> {
}
