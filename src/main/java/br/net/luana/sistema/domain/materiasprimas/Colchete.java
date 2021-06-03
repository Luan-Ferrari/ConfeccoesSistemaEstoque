package br.net.luana.sistema.domain.materiasprimas;

import br.net.luana.sistema.domain.Colecao;
import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.enums.UnidadeMedida;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Colchete extends MateriaPrima {
    private static final long serialVersionUID = 1L;



    public Colchete() {
    }

    public Colchete(Integer id,
                    String referenciaNaFabrica,
                    String observacoes,
                    Boolean desuso,
                    UnidadeMedida unidadeMedida,
                    Fornecedor fornecedor) {
        super(id, referenciaNaFabrica, observacoes, desuso, unidadeMedida, fornecedor);
    }



    @Override
    public void gerarRelatorios() {

    }

    @Override
    public Colecao gerarColecao(List<MateriaPrima> materiasPrima, int ano) {
        return null;
    }
}
