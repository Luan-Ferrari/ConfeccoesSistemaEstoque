package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.CorEntradas;
import br.net.luana.sistema.domain.cores.Cor;

public interface CorEntradasService extends MasterService<CorEntradas, Integer> {

    public Cor buscarCor(Integer id);

    public void acrescentarQuantidadeCorEstoque(Cor cor, Double quantidade);

    public void diminuirQuantidadeCorEstoque(Cor cor, Double quantidade);
}
