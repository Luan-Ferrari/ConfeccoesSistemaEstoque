package br.net.luana.sistema.domain;

import br.net.luana.sistema.domain.cores.Cor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ColecaoCor implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ColecaoCorPK idPK = new ColecaoCorPK();

    private Integer numero;

    public ColecaoCor() {}

    public ColecaoCor(Colecao colecao, Cor cor, Integer numero) {
        idPK.setColecao(colecao);
        idPK.setCor(cor);
        this.numero = numero;
    }

    public Colecao getColecao() { return idPK.getColecao(); }

    public void setColecao(Colecao colecao) { idPK.setColecao(colecao); }

    public Cor getCor() { return idPK.getCor(); };

    public void setCor(Cor cor) { idPK.setCor(cor); }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public ColecaoCorPK getIdPK () {
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
        ColecaoCor that = (ColecaoCor) o;
        return idPK.equals(that.idPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPK);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ColecaoCor{");
        sb.append("numero=").append(numero);
        sb.append('}');
        return sb.toString();
    }
}
