package br.net.luana.sistema.domain.composicoes;

import br.net.luana.sistema.domain.MasterDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Fio implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "id.fio")
    private Set<ComposicaoFio> itens = new HashSet<>();

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

    public Set<ComposicaoFio> getItens() {
        return itens;
    }

    public void setItens(Set<ComposicaoFio> itens) {
        this.itens = itens;
    }

    public List<Composicao> getComposicoes() {
        List<Composicao> lista = new ArrayList<>();
        for(ComposicaoFio x : itens) {
            lista.add(x.getComposicao());
        }
        return lista;
    }
}
