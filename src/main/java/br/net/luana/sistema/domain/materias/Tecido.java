package br.net.luana.sistema.domain.materias;

import br.net.luana.sistema.domain.Colecao;
import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.cores.CorTecido;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.tipos.TipoTecido;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecido extends MateriaPrima {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoTecido tipoTecido;

    @OneToMany(mappedBy = "tecido")
    private List<CorTecido> cores = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private TecidoClasse classe;

    public Tecido() {
    }

    public Tecido(Integer id,
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
