package br.net.luana.sistema.domain.tipos;

import br.net.luana.sistema.domain.MasterDomain;
import br.net.luana.sistema.dto.MasterDTOImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Tipo implements MasterDomain,Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo;

    public Tipo() {
    }

    public Tipo(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipo tipo = (Tipo) o;
        return Objects.equals(id, tipo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
