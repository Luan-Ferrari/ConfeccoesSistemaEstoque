package br.net.luana.sistema.domain.composicoes;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ComposicaoFioPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "composicao_id")
    private Composicao composicao;

    @ManyToOne
    @JoinColumn(name = "fio_id")
    private Fio fio;

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    public Fio getFio() {
        return fio;
    }

    public void setFio(Fio fio) {
        this.fio = fio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComposicaoFioPK that = (ComposicaoFioPK) o;
        return Objects.equals(composicao, that.composicao) && Objects.equals(fio, that.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(composicao, fio);
    }
}
