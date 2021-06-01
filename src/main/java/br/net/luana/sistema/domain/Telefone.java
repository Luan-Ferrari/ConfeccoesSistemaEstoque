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
    private String ddd;
    private String telefone;
    private String ramal;
    private Integer tipoTelefone;

    @ManyToOne
    @JoinColumn(name = "contato_id")
    private Contato contato;

    public Telefone() {
    }

    public Telefone(Integer id,
                    String ddd,
                    String telefone,
                    String ramal,
                    TipoTelefone tipoTelefone,
                    Contato contato) {
        this.id = id;
        this.ddd = ddd;
        this.telefone = telefone;
        this.ramal = ramal;
        this.tipoTelefone = (tipoTelefone==null) ? null : tipoTelefone.getCodigo();
        this.contato = contato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
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
