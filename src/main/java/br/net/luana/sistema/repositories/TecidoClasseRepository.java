package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.TecidoClasse;
import org.springframework.stereotype.Repository;

@Repository
public interface TecidoClasseRepository extends MasterRepository<TecidoClasse, Integer> {

    TecidoClasse findByNome(String nome);
}
