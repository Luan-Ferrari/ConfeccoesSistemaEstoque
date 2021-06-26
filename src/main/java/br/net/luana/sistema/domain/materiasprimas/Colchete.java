package br.net.luana.sistema.domain.materiasprimas;

import br.net.luana.sistema.domain.Colecao;
import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.cores.CorColchete;
import br.net.luana.sistema.domain.cores.CorTecido;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.tipos.Tipo;
import br.net.luana.sistema.domain.tipos.TipoColchete;
import br.net.luana.sistema.domain.tipos.TipoTecido;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Colchete extends MateriaPrima {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoColchete tipoColchete;

    @OneToMany(mappedBy = "colchete")
    private List<CorColchete> cores = new ArrayList<>();

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

    public List<CorColchete> getCores() {
        return cores;
    }

    public void setCores(List<CorColchete> cores) {
        this.cores = cores;
    }
}
