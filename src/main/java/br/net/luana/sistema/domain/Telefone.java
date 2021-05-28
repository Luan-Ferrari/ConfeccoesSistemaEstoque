package br.net.luana.sistema.domain;

import br.net.luana.sistema.domain.enums.TipoTelefone;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String telefone;
    private Integer tipoTelefone;

    @ManyToOne
    @JoinColumn(name = "contato_id")
    private Contato contato;

    public Telefone() {
    }

    public Telefone(Integer id, String telefone, TipoTelefone tipoTelefone) {
        this.id = id;
        this.telefone = telefone;
        this.tipoTelefone = (tipoTelefone==null) ? null : tipoTelefone.getCodigo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoTelefone getTipoTelefone() {
        return TipoTelefone.toEnum(tipoTelefone);
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone.getCodigo();
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(id, telefone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
