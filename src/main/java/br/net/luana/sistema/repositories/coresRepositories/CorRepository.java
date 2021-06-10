package br.net.luana.sistema.repositories.coresRepositories;

import br.net.luana.sistema.domain.cores.Cor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CorRepository<T extends Cor, ID extends Integer>
        extends JpaRepository<T, ID> {
}
