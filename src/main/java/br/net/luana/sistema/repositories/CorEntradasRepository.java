package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.CorEntradas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorEntradasRepository extends MasterRepository<CorEntradas, Integer> {
}
