package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.cores.Cor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorRepository extends JpaRepository<Cor, Integer> {
}
