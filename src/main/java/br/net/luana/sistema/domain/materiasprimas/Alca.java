package br.net.luana.sistema.domain.materiasprimas;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.cores.CorAlca;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.tipos.TipoAlca;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Alca extends MateriaPrima {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoAlca tipoAlca;

    @OneToMany(mappedBy = "alca")
    private List<CorAlca> cores = new ArrayList<>();

    public Alca() {
    }

    public Alca(Integer id,
                String referenciaNaFabrica,
                String observacoes,
                Boolean desuso,
                UnidadeMedida unidadeMedida,
                Fornecedor fornecedor,
                TipoAlca tipoAlca) {
        super(id, referenciaNaFabrica, observacoes, desuso, unidadeMedida, fornecedor);
        this.tipoAlca = tipoAlca;
    }

    public TipoAlca getTipoAlca() {
        return tipoAlca;
    }

    public void setTipoAlca(TipoAlca tipoAlca) {
        this.tipoAlca = tipoAlca;
    }

    public List<CorAlca> getCores() {
        return cores;
    }

    public void setCores(List<CorAlca> cores) {
        this.cores = cores;
    }
}
