package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.materias.MateriaPrima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaPrimaRepository extends JpaRepository<MateriaPrima, Integer> {
}
