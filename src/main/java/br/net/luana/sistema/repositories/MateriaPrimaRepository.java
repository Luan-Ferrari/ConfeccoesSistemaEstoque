package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface MateriaPrimaRepository<T extends MateriaPrima, ID extends Serializable>
        extends JpaRepository<T, ID> {

    @Transactional(readOnly = true)
    Optional<MateriaPrima> findByReferenciaNaFabricaAndFornecedor(String referenciaNaFabrica, Fornecedor fornecedor);
}
