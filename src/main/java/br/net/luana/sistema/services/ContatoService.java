package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.Contato;

public interface ContatoService extends MasterService<Contato, Integer> {

    void adicionarFornecedor(Integer contatoId, Integer fornecedorId);

    void excluirFornecedor(Integer contatoId, Integer fornecedorId);
}
