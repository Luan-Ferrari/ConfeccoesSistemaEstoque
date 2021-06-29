package br.net.luana.sistema.domain.tipos;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.domain.enums.Tamanho;
import br.net.luana.sistema.domain.materiasprimas.Bojo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoBojo extends Tipo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer tamanho;

    @ManyToOne
    @JoinColumn(name = "composicao_id")
    private Composicao composicao;

    @OneToMany(mappedBy = "tipoBojo")
    private List<Bojo> bojos = new ArrayList<>();

    public TipoBojo() {
    }

    public TipoBojo(Integer id, String tipo, Tamanho tamanho, Composicao composicao) {
        super(id, tipo);
        this.tamanho = tamanho.getCodigo();
        this.composicao = composicao;
    }

    public Tamanho getTamanho() {
        return Tamanho.toEnum(tamanho);
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho.getCodigo();
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    public List<Bojo> getBojos() {
        return bojos;
    }

    public void setBojos(List<Bojo> bojos) { this.bojos = bojos; }
}
