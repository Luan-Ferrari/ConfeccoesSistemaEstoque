package br.net.luana.sistema.domain;

import br.net.luana.sistema.domain.enums.FuncaoContato;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private Integer funcaoContato;

    @ManyToMany(mappedBy = "contatos")
    private List<Fornecedor> fornecedores = new ArrayList<>();

    @OneToMany(mappedBy = "contato")
    private List<Telefone> telefones = new ArrayList<>();

    public Contato() {
    }

    public Contato(Integer id, String nome, FuncaoContato funcaoContato) {
        this.id = id;
        this.nome = nome;
        this.funcaoContato = (funcaoContato==null) ? null : funcaoContato.getCodigo();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FuncaoContato getFuncaoContato() {
        return FuncaoContato.toEnum(funcaoContato);
    }

    public void setFuncaoContato(FuncaoContato funcaoContato) {
        this.funcaoContato = funcaoContato.getCodigo();
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
