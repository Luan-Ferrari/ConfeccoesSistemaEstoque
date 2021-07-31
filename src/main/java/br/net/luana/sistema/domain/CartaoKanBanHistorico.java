package br.net.luana.sistema.domain;

import br.net.luana.sistema.domain.enums.MotivoBaixaKanBan;
import br.net.luana.sistema.domain.enums.UnidadeMedida;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class CartaoKanBanHistorico implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer codigoCartao;
    private Double quantidadeArmazenada;
    private Integer unidadeMedida;
    private LocalDate dataBaixa;
    private Integer motivoBaixa;

    @ManyToOne
    @JoinColumn(name = "cor_entrada_id")
    private CorEntradas corEntrada;


    public CartaoKanBanHistorico() {
    }

    public CartaoKanBanHistorico(Integer id, Integer codigoCartao, Double quantidadeArmazenada,
                                 UnidadeMedida unidadeMedida, LocalDate dataBaixa, MotivoBaixaKanBan motivoBaixa,
                                 CorEntradas corEntradas) {
        this.id = id;
        this.codigoCartao = codigoCartao;
        this.quantidadeArmazenada = quantidadeArmazenada;
        this.unidadeMedida = (unidadeMedida==null) ? null : unidadeMedida.getCodigo();
        this.dataBaixa = dataBaixa;
        this.corEntrada = corEntrada;
        this.motivoBaixa = (motivoBaixa==null) ? null : motivoBaixa.getCodigo();
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

    public LocalDate getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public MotivoBaixaKanBan getMotivoBaixa() { return MotivoBaixaKanBan.toEnum(motivoBaixa); }

    public void setMotivoBaixa(MotivoBaixaKanBan motivoBaixa) {
        this.motivoBaixa = motivoBaixa.getCodigo();
    }

    public CorEntradas getCorEntradas() {
        return corEntrada;
    }

    public void setCorEntradas(CorEntradas corEntradas) {
        this.corEntrada = corEntradas;
    }
}
