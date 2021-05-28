package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.materias.TecidoClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecidoClasseRepository extends JpaRepository<TecidoClasse, Integer> {
}
