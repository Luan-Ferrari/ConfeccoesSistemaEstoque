package br.net.luana.sistema.repositories.materiasPrimasRepositories;

import br.net.luana.sistema.domain.materiasprimas.TecidoClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecidoClasseRepository extends JpaRepository<TecidoClasse, Integer> {
}
