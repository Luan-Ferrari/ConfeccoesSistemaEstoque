package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.CartaoKanBan;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class CartaoKanBanDTO extends MasterDTOImpl<CartaoKanBan, CartaoKanBanDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer codigoCartao;
    private Boolean emUso;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private Double quantidadeArmazenada;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private Integer unidadeMedida;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private CorEntradasDTO corEntrada;

    private List<CartaoKanBanDTO> cartoesParaBaixar = new ArrayList<>();

    public CartaoKanBanDTO() {
    }

    public CartaoKanBanDTO(CartaoKanBan entity) {
        this.id = entity.getId();
        this.codigoCartao = entity.getCodigoCartao();
        this.emUso = entity.getEmUso();
        this.quantidadeArmazenada = entity.getQuantidadeArmazenada();
        this.unidadeMedida = (entity.getUnidadeMedida() == null) ? null : entity.getUnidadeMedida().getCodigo();
        this.corEntrada = corEntrada.makeDTO(entity.getCorEntradas());
        }

    @Override
    public CartaoKanBanDTO makeDTO(CartaoKanBan entity) { return new CartaoKanBanDTO(entity); }

    @Override
    public CartaoKanBan makeEntityfromDTO(CartaoKanBanDTO dto) {
        return new CartaoKanBan(dto.getId(),
                dto.getCodigoCartao(), dto.getEmUso(), dto.getQuantidadeArmazenada(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), corEntrada.makeEntityfromDTO(dto.corEntrada));
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

    public Integer getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(Integer unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public CorEntradasDTO getCorEntrada() {
        return corEntrada;
    }

    public void setCorEntrada(CorEntradasDTO corEntrada) {
        this.corEntrada = corEntrada;
    }

    public List<CartaoKanBanDTO> getCartoesParaBaixar() {
        return cartoesParaBaixar;
    }

    public void setCartoesParaBaixar(List<CartaoKanBanDTO> cartoesParaBaixar) {
        this.cartoesParaBaixar = cartoesParaBaixar;
    }
}
