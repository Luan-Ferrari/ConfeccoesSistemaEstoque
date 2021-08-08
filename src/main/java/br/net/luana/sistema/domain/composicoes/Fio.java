package br.net.luana.sistema.domain.composicoes;

import br.net.luana.sistema.domain.MasterDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Fio implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "idPK.fio")
    private List<ComposicaoFio> itensFios = new ArrayList<>();

    public Fio() {
    }

    public Fio(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
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

    public List<ComposicaoFio> getItensFios() {
        return itensFios;
    }

    public void setItensFios(List<ComposicaoFio> itensFios) {
        this.itensFios = itensFios;
    }

    public List<Composicao> getComposicoes() {
        List<Composicao> lista = new ArrayList<>();
        for(ComposicaoFio x : itensFios) {
            lista.add(x.getComposicao());
        }
        return lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fio fio = (Fio) o;
        return id.equals(fio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
