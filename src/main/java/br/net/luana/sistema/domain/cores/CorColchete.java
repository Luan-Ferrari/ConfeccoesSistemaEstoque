package br.net.luana.sistema.domain.cores;

import br.net.luana.sistema.domain.materiasprimas.Colchete;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CorColchete extends Cor {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "materia_prima_id")
    private Colchete colchete;

    public CorColchete() {
    }

    public CorColchete(Integer id,
                       String referenciaNaFabrica,
                       String nome,
                       String observacoes,
                       Double quantidadeEstoque,
                       Colchete colchete) {
        super(id, referenciaNaFabrica, nome, observacoes, quantidadeEstoque);
        this.colchete = colchete;
    }

    public Colchete getColchete() {
        return colchete;
    }

    public void setColchete(Colchete colchete) {
        this.colchete = colchete;
    }

}
