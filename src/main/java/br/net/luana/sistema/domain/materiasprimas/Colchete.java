package br.net.luana.sistema.domain.materiasprimas;

import br.net.luana.sistema.domain.Colecao;
import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.tipos.TipoColchete;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@Entity
public class Colchete extends MateriaPrima implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoColchete tipoColchete;

    public Colchete() {
    }

    public Colchete(Integer id,
                    String referenciaNaFabrica,
                    String observacoes,
                    Boolean desuso,
                    UnidadeMedida unidadeMedida,
                    Fornecedor fornecedor,
                    TipoColchete tipoColchete) {
        super(id, referenciaNaFabrica, observacoes, desuso, unidadeMedida, fornecedor);
        this.tipoColchete = tipoColchete;
    }

    public TipoColchete getTipoColchete() {
        return tipoColchete;
    }

    public void setTipoColchete(TipoColchete tipoColchete) {
        this.tipoColchete = tipoColchete;
    }

    @Override
    public void gerarRelatorios() {

    }

    @Override
    public Colecao gerarColecao(List<MateriaPrima> materiasPrima, int ano) {
        return null;
    }
}
