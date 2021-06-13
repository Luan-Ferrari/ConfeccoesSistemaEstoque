package br.net.luana.sistema.domain.cores;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cor implements CorInterface, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String referenciaNaFabrica;
    private String nome;
    private String observacoes;
    private Double quantidadeEstoque;

    @OneToMany(mappedBy = "cor")
    private List<CorEntradas> entradas = new ArrayList<>();

    public Cor() {
    }

    public Cor(Integer id,
               String referenciaNaFabrica,
               String nome,
               String observacoes,
               Double quantidadeEstoque) {
        this.id = id;
        this.referenciaNaFabrica = referenciaNaFabrica;
        this.nome = nome;
        this.observacoes = observacoes;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenciaNaFabrica() {
        return referenciaNaFabrica;
    }

    public void setReferenciaNaFabrica(String referenciaNaFabrica) {
        this.referenciaNaFabrica = referenciaNaFabrica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public List<CorEntradas> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<CorEntradas> entradas) {
        this.entradas = entradas;
    }


    @Override
    public void acrescentarQuantidade(Double quantidadeEntrada) {
        this.quantidadeEstoque += quantidadeEntrada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cor that = (Cor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
