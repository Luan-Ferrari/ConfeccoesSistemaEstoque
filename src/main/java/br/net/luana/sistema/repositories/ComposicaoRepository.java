package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.Composicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposicaoRepository extends JpaRepository<Composicao, Integer> {
}
