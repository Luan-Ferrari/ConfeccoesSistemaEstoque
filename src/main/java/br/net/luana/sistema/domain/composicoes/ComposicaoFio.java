package br.net.luana.sistema.domain.composicoes;

import br.net.luana.sistema.domain.MasterDomain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ComposicaoFio implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    //@JsonIgnore
    @EmbeddedId
    private ComposicaoFioPK id = new ComposicaoFioPK();

    private Integer porcentagem;

    public ComposicaoFio() {}

    public ComposicaoFio(Composicao composicao, Fio fio, Integer porcentagem) {
        id.setComposicao(composicao);
        id.setFio(fio);
        this.porcentagem = porcentagem;
    }

    public Composicao getComposicao() { return id.getComposicao(); }

    public void setComposicao(Composicao composicao) { id.setComposicao(composicao); }

    public Fio getFio() { return id.getFio(); };

    public void setFio(Fio fio) { id.setFio(fio); }

    public Integer getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Integer porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public Integer getId() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComposicaoFio that = (ComposicaoFio) o;
        return Objects.equals(id, that.id) && Objects.equals(porcentagem, that.porcentagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, porcentagem);
    }
}
