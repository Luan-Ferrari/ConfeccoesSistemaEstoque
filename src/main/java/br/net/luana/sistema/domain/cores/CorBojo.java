package br.net.luana.sistema.domain.cores;

import br.net.luana.sistema.domain.CaixaBojo;
import br.net.luana.sistema.domain.materiasprimas.Bojo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CorBojo extends Cor {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "materia_prima_id")
    private Bojo bojo;

    @ManyToMany(mappedBy = "coresArmazenadas")
    private List<CaixaBojo> caixas = new ArrayList<>();

    public CorBojo() {
    }

    public CorBojo(Integer id,
                   String referenciaNaFabrica,
                   String nome,
                   String observacoes,
                   Double quantidadeEstoque,
                   Bojo bojo) {
        super(id, referenciaNaFabrica, nome, observacoes, quantidadeEstoque);
        this.bojo = bojo;
    }

    public Bojo getBojo() {
        return bojo;
    }

    public void setBojo(Bojo bojo) {
        this.bojo = bojo;
    }

    public List<CaixaBojo> getCaixas() {
        return caixas;
    }

    public void setCaixas(List<CaixaBojo> caixas) {
        this.caixas = caixas;
    }
}
