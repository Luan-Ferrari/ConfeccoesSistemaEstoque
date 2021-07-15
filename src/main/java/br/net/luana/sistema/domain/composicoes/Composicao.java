package br.net.luana.sistema.domain.composicoes;

import br.net.luana.sistema.domain.MasterDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Composicao implements MasterDomain, Serializable {
    private static final long serialVerisonUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numero;

    @OneToMany(mappedBy = "id.composicao")
    private List<ComposicaoFio> itensFios = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "composicao_modo_lavar",
            joinColumns = @JoinColumn(name = "composicao_id"),
            inverseJoinColumns = @JoinColumn(name = "modo_lavar_id"))
    private List<ModoLavar> itensModoLavar = new ArrayList<>();

    public Composicao() {
    }

    public Composicao(Integer id, Integer numero) {
        this.id = id;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<ComposicaoFio> getItensFios() {
        return itensFios;
    }

    public void setItensFios(List<ComposicaoFio> itens) {
        this.itensFios = itens;
    }

    public List<ModoLavar> getItensModoLavar() {
        return itensModoLavar;
    }

    public void setItensModoLavar(List<ModoLavar> itensModoLavar) {
        this.itensModoLavar = itensModoLavar;
    }

    public List<Fio> getFios() {
        List<Fio> lista = new ArrayList<>();
        for(ComposicaoFio x : itensFios) {
            lista.add(x.getFio());
        }
        return lista;
    }

    public List<Integer> getPorcentagens() {
        List<Integer> lista = new ArrayList<>();
        for(ComposicaoFio x : itensFios) {
            lista.add(x.getPorcentagem());
        }
        return lista;
    }

    public List<ModoLavar> getModoLavar() {
        List<ModoLavar> lista = new ArrayList<>();
        for(ModoLavar x : itensModoLavar) {
            lista.add(x);
        }
        return lista;
    }

    public boolean verificaTotalComposicao() {
        Integer soma = 0;
        for (ComposicaoFio composicaoFio : itensFios) {
            soma += composicaoFio.getPorcentagem();
        }
        if(soma != 100) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composicao that = (Composicao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
