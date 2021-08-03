package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.Contato;
import br.net.luana.sistema.domain.Fornecedor;

public interface FornecedorService extends MasterService<Fornecedor, Integer> {

    void adicionarContato(Contato contato, Integer fornecedorId);

    void excluirContato(Contato contato, Integer fornecedorId);
}
