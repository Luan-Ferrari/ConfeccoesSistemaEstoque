package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.enums.MotivoBaixaKanBan;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.CartaoKanBanHistorico;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
public class CartaoKanBanHistoricoDTO extends MasterDTOImpl<CartaoKanBanHistorico, CartaoKanBanHistoricoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer codigoCartao;
    private Double quantidadeArmazenada;
    private Integer unidadeMedida;
    private LocalDate dataBaixa;
    private Integer motivoBaixa;


    public CartaoKanBanHistoricoDTO() {
    }

    public CartaoKanBanHistoricoDTO(CartaoKanBanHistorico entity) {
        this.id = entity.getId();
        this.codigoCartao = entity.getCodigoCartao();
        this.quantidadeArmazenada = entity.getQuantidadeArmazenada();
        this.unidadeMedida = (entity.getUnidadeMedida() == null) ? null : entity.getUnidadeMedida().getCodigo();
        this.dataBaixa = entity.getDataBaixa();
        this.motivoBaixa = (entity.getMotivoBaixa()==null) ? null : entity.getMotivoBaixa().getCodigo();
        }

    @Override
    public CartaoKanBanHistoricoDTO makeDTO(CartaoKanBanHistorico entity) { return new CartaoKanBanHistoricoDTO(entity); }

    @Override
    public CartaoKanBanHistorico makeEntityfromDTO(CartaoKanBanHistoricoDTO dto) {
        return new CartaoKanBanHistorico(dto.getId(),
                dto.getCodigoCartao(), dto.getQuantidadeArmazenada(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), dto.getDataBaixa(),
                MotivoBaixaKanBan.toEnum(dto.getMotivoBaixa()), null);
    }

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

    public Integer getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(Integer unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public LocalDate getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Integer getMotivoBaixa() {
        return motivoBaixa;
    }

    public void setMotivoBaixa(Integer motivoBaixa) {
        this.motivoBaixa = motivoBaixa;
    }
}
