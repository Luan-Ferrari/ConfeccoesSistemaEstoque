package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.Colecao;
import br.net.luana.sistema.domain.cores.Cor;

import java.util.List;

public interface ColecaoService extends MasterService<Colecao, Integer> {

    List<Integer> verificaNumeracaoDuplicadaInsert (List<Integer> numeracoes);

    List<Integer> verificaNumeracaoDuplicadaUpdate (List<Integer> numeracoes,
                                                           List<Integer> numeracoesNovas);

    void adicionarItensColecao (Integer colecaoId, List<Cor> coresNovas,
                                List<Integer> numeracoesNovas);

    void excluirItensColecao (Integer colecaoId, List<Cor> coresExcluir);
}
