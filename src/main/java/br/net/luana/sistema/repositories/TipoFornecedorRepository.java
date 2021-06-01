package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.TipoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFornecedorRepository extends JpaRepository<TipoFornecedor, Integer> {
}
