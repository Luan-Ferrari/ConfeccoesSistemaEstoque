package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.Colecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColecaoRepository extends JpaRepository<Colecao, Integer> {
}
