package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.materiasprimas.Colchete;

import org.springframework.stereotype.Repository;


@Repository("colcheteRepository")
public interface ColcheteRepository extends MateriaPrimaRepository<Colchete, Integer> {

}
