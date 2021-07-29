package br.net.luana.sistema.domain.materiasprimas;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.cores.CorRenda;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.tipos.TipoRenda;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Renda extends MateriaPrima {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoRenda tipoRenda;

    @OneToMany(mappedBy = "renda")
    private List<CorRenda> cores = new ArrayList<>();

    public Renda() {
    }

    public Renda(Integer id,
                 String referenciaNaFabrica,
                 String observacoes,
                 Boolean desuso,
                 UnidadeMedida unidadeMedida,
                 Double quantidadeKanBan,
                 Fornecedor fornecedor,
                 TipoRenda tipoRenda) {
        super(id, referenciaNaFabrica, observacoes, desuso, unidadeMedida, quantidadeKanBan, fornecedor);
        this.tipoRenda = tipoRenda;
    }

    public TipoRenda getTipoRenda() {
        return tipoRenda;
    }

    public void setTipoRenda(TipoRenda tipoRenda) {
        this.tipoRenda = tipoRenda;
    }

    public List<CorRenda> getCores() {
        return cores;
    }

    public void setCores(List<CorRenda> cores) {
        this.cores = cores;
    }
}
