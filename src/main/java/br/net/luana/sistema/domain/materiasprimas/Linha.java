package br.net.luana.sistema.domain.materiasprimas;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.cores.CorLinha;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.tipos.TipoLinha;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Linha extends MateriaPrima {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoLinha tipoLinha;

    @OneToMany(mappedBy = "LINHA")
    private List<CorLinha> cores = new ArrayList<>();

    public Linha() {
    }

    public Linha(Integer id,
                 String referenciaNaFabrica,
                 String observacoes,
                 Boolean desuso,
                 UnidadeMedida unidadeMedida,
                 Fornecedor fornecedor,
                 TipoLinha tipoLinha) {
        super(id, referenciaNaFabrica, observacoes, desuso, unidadeMedida, fornecedor);
        this.tipoLinha = tipoLinha;
    }

    public TipoLinha getTipoLinha() {
        return tipoLinha;
    }

    public void setTipoLinha(TipoLinha tipoLinha) {
        this.tipoLinha = tipoLinha;
    }

    public List<CorLinha> getCores() {
        return cores;
    }

    public void setCores(List<CorLinha> cores) {
        this.cores = cores;
    }
}
