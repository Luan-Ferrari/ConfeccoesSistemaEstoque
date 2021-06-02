package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.materiasprimas.Colchete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColcheteRepository extends JpaRepository<Colchete, Integer> {
}
