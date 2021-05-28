package br.net.luana.sistema.domain.interfaces;

import br.net.luana.sistema.domain.Colecao;
import br.net.luana.sistema.domain.materias.MateriaPrima;

import java.util.List;

public interface MateriaPrimaInterface {

    void gerarRelatorios();

    Colecao gerarColecao(List<MateriaPrima> materiasPrima, int ano);
}
