package br.net.luana.sistema.domain;

import br.net.luana.sistema.domain.enums.UnidadeMedida;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CartaoKanBan implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer codigoCartao;
    private Boolean emUso;
    private Double quantidadeArmazenada;
    private Integer unidadeMedida;

    @ManyToOne
    @JoinColumn(name = "cor_entradas_id")
    private CorEntradas corEntrada;


    public CartaoKanBan() {
    }

    public CartaoKanBan(Integer id, Integer codigoCartao, Boolean emUso, Double quantidadeArmazenada,
                        UnidadeMedida unidadeMedida, CorEntradas corEntradas) {
        this.id = id;
        this.codigoCartao = codigoCartao;
        this.emUso = emUso;
        this.quantidadeArmazenada = quantidadeArmazenada;
        this.unidadeMedida = (unidadeMedida==null) ? null : unidadeMedida.getCodigo();
        this.corEntrada = corEntrada;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoCartao() {
        return codigoCartao;
    }

    public void setCodigoCartao(Integer codigoCartao) {
        this.codigoCartao = codigoCartao;
    }

    public Boolean getEmUso() {
        return emUso;
    }

    public void setEmUso(Boolean emUso) {
        this.emUso = emUso;
    }

    public Double getQuantidadeArmazenada() {
        return quantidadeArmazenada;
    }

    public void setQuantidadeArmazenada(Double quantidadeArmazenada) {
        this.quantidadeArmazenada = quantidadeArmazenada;
    }

    public UnidadeMedida getUnidadeMedida() { return UnidadeMedida.toEnum(unidadeMedida); }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida.getCodigo();
    }

    public CorEntradas getCorEntradas() {
        return corEntrada;
    }

    public void setCorEntradas(CorEntradas corEntradas) {
        this.corEntrada = corEntradas;
    }
}
