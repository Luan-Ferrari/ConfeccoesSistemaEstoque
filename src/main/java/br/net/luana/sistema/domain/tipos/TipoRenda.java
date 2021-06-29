package br.net.luana.sistema.domain.tipos;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.domain.materiasprimas.Renda;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoRenda extends Tipo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "composicao_id")
    private Composicao composicao;

    @OneToMany(mappedBy = "tipoRenda")
    private List<Renda> rendas = new ArrayList<>();

    public TipoRenda() {
    }

    public TipoRenda(Integer id, String tipo, Composicao composicao) {
        super(id, tipo);
        this.composicao = composicao;
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    public List<Renda> getRendas() {
        return rendas;
    }

    public void setRendas(List<Renda> rendas) {
        this.rendas = rendas;
    }
}
