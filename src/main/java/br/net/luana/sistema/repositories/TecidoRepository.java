package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository("tecido")
public interface TecidoRepository extends MateriaPrimaRepository<Tecido, Integer> {

}
