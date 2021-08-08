package br.net.luana.sistema.domain;

import br.net.luana.sistema.domain.cores.Cor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Colecao implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer ano;

    @OneToMany(mappedBy = "idPK.colecao")
    private List<ColecaoCor> itensCores = new ArrayList<>();

    public Colecao() {
    }

    public Colecao(Integer id, String nome, Integer ano) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public List<ColecaoCor> getItensCores() {
        return itensCores;
    }

    public void setItensCores(List<ColecaoCor> itensCores) {
        this.itensCores = itensCores;
    }

    public List<Cor> getCores() {
        List<Cor> lista = new ArrayList<>();
        for(ColecaoCor x : itensCores) {
            lista.add(x.getCor());
        }
        return lista;
    }

    public List<Integer> getNumeros() {
        List<Integer> lista = new ArrayList<>();
        for(ColecaoCor x : itensCores) {
            lista.add(x.getNumero());
        }
        return lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colecao colecao = (Colecao) o;
        return Objects.equals(id, colecao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
