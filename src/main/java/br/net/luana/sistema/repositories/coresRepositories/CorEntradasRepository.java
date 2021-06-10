package br.net.luana.sistema.repositories.coresRepositories;

import br.net.luana.sistema.domain.cores.CorEntradas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorEntradasRepository extends JpaRepository<CorEntradas, Integer> {
}
