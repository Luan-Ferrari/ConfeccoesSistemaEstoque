package br.net.luana.sistema.domain;

import br.net.luana.sistema.domain.cores.CorBojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CaixaBojo implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeCaixa;

    @ManyToMany
    @JoinTable(name = "caixa_cor_bojo",
        joinColumns = @JoinColumn(name = "caixa_bojo_id"),
        inverseJoinColumns = @JoinColumn(name = "cor_bojo_id"))
    private List<CorBojo> coresArmazenadas = new ArrayList<>();

    public CaixaBojo() {
    }

    public CaixaBojo(Integer id, String nomeCaixa) {
        this.id = id;
        this.nomeCaixa = nomeCaixa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCaixa() {
        return nomeCaixa;
    }

    public void setNomeCaixa(String nomeCaixa) {
        this.nomeCaixa = nomeCaixa;
    }

    public List<CorBojo> getCoresArmazenadas() {
        return coresArmazenadas;
    }

    public void setCoresArmazenadas(List<CorBojo> coresArmazenadas) {
        this.coresArmazenadas = coresArmazenadas;
    }
}
