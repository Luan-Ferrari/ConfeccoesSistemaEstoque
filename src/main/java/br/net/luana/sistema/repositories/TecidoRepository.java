package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TecidoRepository extends JpaRepository<Tecido, Integer> {

    @Transactional(readOnly = true)
    Optional<Tecido> findByReferenciaNaFabricaAndFornecedor(String referenciaNaFabrica, Fornecedor fornecedor);
}
