package br.net.luana.sistema.domain.cores;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.materiasprimas.Tecido;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CorTecido extends Cor {
    private static final long serialVersionUID = 1L;


    @ManyToOne
    @JoinColumn(name = "materia_prima_id")
    private Tecido tecido;

    @ManyToOne
    @JoinColumn(name = "composicao_id")
    private Composicao composicao;

    public CorTecido() {
    }

    public CorTecido(Integer id,
                     String referenciaNaFabrica,
                     String nome,
                     String observacoes,
                     Double quantidadeEstoque,
                     Double quantidadeKanBan,
                     UnidadeMedida unidadeMedida,
                     Tecido tecido,
                     Composicao composicao) {
        super(id, referenciaNaFabrica, nome, observacoes, quantidadeEstoque,
                quantidadeKanBan, unidadeMedida);
        this.composicao = composicao;
        this.tecido = tecido;
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    public Tecido getTecido() {
        return tecido;
    }

    public void setTecido(Tecido tecido) {
        this.tecido = tecido;
    }
}
