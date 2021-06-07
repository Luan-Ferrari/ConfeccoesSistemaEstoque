package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.materiasprimas.Colchete;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository("colcheteRepository")
public interface ColcheteRepository extends MateriaPrimaRepository<Colchete, Integer> {

}
