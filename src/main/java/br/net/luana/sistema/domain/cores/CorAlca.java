package br.net.luana.sistema.domain.cores;

import br.net.luana.sistema.domain.materiasprimas.Alca;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CorAlca extends Cor {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "materia_prima_id")
    private Alca alca;

    public CorAlca() {
    }

    public CorAlca(Integer id,
                   String referenciaNaFabrica,
                   String nome,
                   String observacoes,
                   Double quantidadeEstoque,
                   Alca alca) {
        super(id, referenciaNaFabrica, nome, observacoes, quantidadeEstoque);
        this.alca = alca;
    }

    public Alca getAlca() {
        return alca;
    }

    public void setAlca(Alca alca) {
        this.alca = alca;
    }
}
