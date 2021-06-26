package br.net.luana.sistema.domain.materiasprimas;

import br.net.luana.sistema.domain.Colecao;
import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.TecidoClasse;
import br.net.luana.sistema.domain.cores.CorTecido;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.tipos.TipoTecido;

import javax.persistence.*;
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
                  Fornecedor fornecedor,
                  TipoTecido tipoTecido,
                  TecidoClasse classe) {
        super(id, referenciaNaFabrica, observacoes, desuso, unidadeMedida, fornecedor);
        this.tipoTecido = tipoTecido;
        this.classe = classe;
    }

    public TipoTecido getTipoTecido() {
        return tipoTecido;
    }

    public void setTipoTecido(TipoTecido tipoTecido) {
        this.tipoTecido = tipoTecido;
    }

    public List<CorTecido> getCores() {
        return cores;
    }

    public void setCores(List<CorTecido> cores) {
        this.cores = cores;
    }

    public TecidoClasse getClasse() {
        return classe;
    }

    public void setClasse(TecidoClasse classe) {
        this.classe = classe;
    }

}
