package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.Fornecedor;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends MasterRepository<Fornecedor, Integer> {

    Fornecedor findByCnpj(String cnpj);
}
