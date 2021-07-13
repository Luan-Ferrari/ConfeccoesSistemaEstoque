package br.net.luana.sistema.domain.cores;

import br.net.luana.sistema.domain.materiasprimas.Elastico;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CorElastico extends Cor {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "materia_prima_id")
    private Elastico elastico;

    public CorElastico() {
    }

    public CorElastico(Integer id,
                       String referenciaNaFabrica,
                       String nome,
                       String observacoes,
                       Double quantidadeEstoque,
                       Elastico elastico) {
        super(id, referenciaNaFabrica, nome, observacoes, quantidadeEstoque);
        this.elastico = elastico;
    }

    public Elastico getElastico() {
        return elastico;
    }

    public void setElastico(Elastico elastico) {
        this.elastico = elastico;
    }
}
