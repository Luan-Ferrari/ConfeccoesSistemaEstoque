package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.tipos.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer> {
}
