package br.net.luana.sistema.repositories.materiaPrimaRepositories;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public interface TecidoRepository extends MateriaPrimaRepository<Tecido, Integer> {

}
