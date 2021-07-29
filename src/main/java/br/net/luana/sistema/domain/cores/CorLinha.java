package br.net.luana.sistema.domain.cores;

import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.materiasprimas.Linha;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CorLinha extends Cor {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "materia_prima_id")
    private Linha linha;

    public CorLinha() {
    }

    public CorLinha(Integer id,
                    String referenciaNaFabrica,
                    String nome,
                    String observacoes,
                    Double quantidadeEstoque,
                    Double quantidadeKanBan,
                    UnidadeMedida unidadeMedida,
                    Linha linha) {
        super(id, referenciaNaFabrica, nome, observacoes, quantidadeEstoque,
                quantidadeKanBan, unidadeMedida);
        this.linha = linha;
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }
}
