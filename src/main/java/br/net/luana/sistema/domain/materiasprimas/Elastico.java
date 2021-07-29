package br.net.luana.sistema.domain.materiasprimas;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.cores.CorElastico;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.tipos.TipoElastico;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Elastico extends MateriaPrima {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoElastico tipoElastico;

    @OneToMany(mappedBy = "elastico")
    private List<CorElastico> cores = new ArrayList<>();

    public Elastico() {
    }

    public Elastico(Integer id,
                    String referenciaNaFabrica,
                    String observacoes,
                    Boolean desuso,
                    UnidadeMedida unidadeMedida,
                    Double quantidadeKanBan,
                    Fornecedor fornecedor,
                    TipoElastico tipoElastico) {
        super(id, referenciaNaFabrica, observacoes, desuso, unidadeMedida, quantidadeKanBan, fornecedor);
        this.tipoElastico = tipoElastico;
    }

    public TipoElastico getTipoElastico() {
        return tipoElastico;
    }

    public void setTipoElastico(TipoElastico tipoElastico) {
        this.tipoElastico = tipoElastico;
    }

    public List<CorElastico> getCores() {
        return cores;
    }

    public void setCores(List<CorElastico> cores) {
        this.cores = cores;
    }
}
