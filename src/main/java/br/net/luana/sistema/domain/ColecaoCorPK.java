package br.net.luana.sistema.domain;

import br.net.luana.sistema.domain.cores.Cor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ColecaoCorPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "colecao_id")
    private Colecao colecao;

    @ManyToOne
    @JoinColumn(name = "cor_id")
    private Cor cor;

    public Colecao getColecao() {
        return colecao;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColecaoCorPK that = (ColecaoCorPK) o;
        return Objects.equals(colecao, that.colecao) && Objects.equals(cor, that.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colecao, cor);
    }
}
