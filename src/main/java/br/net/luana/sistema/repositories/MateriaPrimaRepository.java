package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface MateriaPrimaRepository extends JpaRepository<MateriaPrima, Integer> {

    @Transactional(readOnly = true)
    Optional<MateriaPrima> findByReferenciaNaFabricaAndFornecedor(String referenciaNaFabrica, Fornecedor fornecedor);
}
