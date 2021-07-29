package br.net.luana.sistema.domain.materiasprimas;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.cores.CorBojo;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.tipos.TipoBojo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bojo extends MateriaPrima {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoBojo tipoBojo;

    @OneToMany(mappedBy = "bojo")
    private List<CorBojo> cores = new ArrayList<>();

    public Bojo() {
    }

    public Bojo(Integer id,
                String referenciaNaFabrica,
                String observacoes,
                Boolean desuso,
                UnidadeMedida unidadeMedida,
                Double quantidadeKanBan,
                Fornecedor fornecedor,
                TipoBojo tipoBojo) {
        super(id, referenciaNaFabrica, observacoes, desuso, unidadeMedida, quantidadeKanBan, fornecedor);
        this.tipoBojo = tipoBojo;
    }

    public TipoBojo getTipoBojo() {
        return tipoBojo;
    }

    public void setTipoBojo(TipoBojo tipoBojo) {
        this.tipoBojo = tipoBojo;
    }

    public List<CorBojo> getCores() {
        return cores;
    }

    public void setCores(List<CorBojo> cores) {
        this.cores = cores;
    }
}
