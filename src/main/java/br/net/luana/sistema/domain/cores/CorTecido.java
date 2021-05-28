package br.net.luana.sistema.domain.cores;

import br.net.luana.sistema.domain.Composicao;
import br.net.luana.sistema.domain.materias.Tecido;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class CorTecido extends Cor {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "composicao_id")
    private Composicao composicao;

    @ManyToOne
    @JoinColumn(name = "tecido_id")
    private Tecido tecido;

    public CorTecido() {
    }

    public CorTecido(Integer id,
                     String referenciaNaFabrica,
                     String nome,
                     String observacoes,
                     Composicao composicao,
                     Tecido tecido) {
        super(id, referenciaNaFabrica, nome, observacoes);
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

    @Override
    public void diminuirQuantidade(Double quantidade) {

    }
}
