package br.net.luana.sistema.domain.interfaces;

import br.net.luana.sistema.domain.Colecao;
import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;

import java.util.List;

public interface MateriaPrimaInterface {

    void gerarRelatorios();

    Colecao gerarColecao(List<MateriaPrima> materiasPrima, int ano);
}
