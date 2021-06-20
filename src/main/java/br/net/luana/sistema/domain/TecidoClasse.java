package br.net.luana.sistema.domain;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class TecidoClasse implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "classe")
    private List<Tecido> tecidos = new ArrayList<>();

    public TecidoClasse() {
    }

    public TecidoClasse(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Tecido> getTecidos() {
        return tecidos;
    }

    public void setTecidos(List<Tecido> tecidos) {
        this.tecidos = tecidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TecidoClasse that = (TecidoClasse) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
