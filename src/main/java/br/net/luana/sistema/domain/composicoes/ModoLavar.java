package br.net.luana.sistema.domain.composicoes;

import br.net.luana.sistema.domain.MasterDomain;
import br.net.luana.sistema.domain.enums.CategoriaModoLavar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ModoLavar implements MasterDomain, Serializable {
    private static final long serialVerisonUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer categoria;
    private String descricao;
    private String imageName;

    public ModoLavar() {
    }

    public ModoLavar(Integer id, CategoriaModoLavar categoriaModoLavar, String descricao) {
        this.id = id;
        this.categoria = (categoriaModoLavar == null) ? null : categoriaModoLavar.getCodigo();
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoriaModoLavar getCategoria() {
        return CategoriaModoLavar.toEnum(categoria);
    }

    public void setCategoria(CategoriaModoLavar categoria) {
        this.categoria = categoria.getCodigo();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModoLavar modoLavar = (ModoLavar) o;
        return Objects.equals(id, modoLavar.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
