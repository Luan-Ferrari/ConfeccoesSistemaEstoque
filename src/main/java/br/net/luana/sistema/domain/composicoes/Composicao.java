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
    private Set<ComposicaoFio> itens = new HashSet<>();

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

    public Set<ComposicaoFio> getItens() {
        return itens;
    }

    public void setItens(Set<ComposicaoFio> itens) {
        this.itens = itens;
    }

    public List<Fio> getFios() {
        List<Fio> lista = new ArrayList<>();
        for(ComposicaoFio x : itens) {
            lista.add(x.getFio());
        }
        return lista;
    }

    public boolean verificaTotalComposicao() {
        Integer soma = 0;
        for (ComposicaoFio composicaoFio : itens) {
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
