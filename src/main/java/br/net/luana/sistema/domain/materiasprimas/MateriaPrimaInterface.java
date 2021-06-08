package br.net.luana.sistema.domain.materiasprimas;

import br.net.luana.sistema.domain.Colecao;

import java.util.List;

public interface MateriaPrimaInterface {

    void gerarRelatorios();

    Colecao gerarColecao(List<MateriaPrima> materiasPrima, int ano);
}
