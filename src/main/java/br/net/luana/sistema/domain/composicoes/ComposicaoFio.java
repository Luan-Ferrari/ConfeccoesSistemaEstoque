package br.net.luana.sistema.domain.composicoes;

import br.net.luana.sistema.domain.MasterDomain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ComposicaoFio implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ComposicaoFioPK idPK = new ComposicaoFioPK();

    private Integer porcentagem;

    public ComposicaoFio() {}

    public ComposicaoFio(Composicao composicao, Fio fio, Integer porcentagem) {
        idPK.setComposicao(composicao);
        idPK.setFio(fio);
        this.porcentagem = porcentagem;
    }

    public Composicao getComposicao() { return idPK.getComposicao(); }

    public void setComposicao(Composicao composicao) { idPK.setComposicao(composicao); }

    public Fio getFio() { return idPK.getFio(); };

    public void setFio(Fio fio) { idPK.setFio(fio); }

    public Integer getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Integer porcentagem) {
        this.porcentagem = porcentagem;
    }

    public ComposicaoFioPK getIdPK() {
        return idPK;
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
        return Objects.equals(idPK, that.idPK)
                && Objects.equals(porcentagem, that.porcentagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPK, porcentagem);
    }
}
