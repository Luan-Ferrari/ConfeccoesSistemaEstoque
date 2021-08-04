package br.net.luana.sistema.repositories.corRepositories;

import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.repositories.MasterRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorRepository<T extends Cor, ID extends Integer>
        extends MasterRepository<T, ID> {

    Cor findByReferenciaNaFabrica(String referenciaNaFabrica);
}
