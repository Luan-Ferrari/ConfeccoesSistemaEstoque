package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.CorEntradas;
import br.net.luana.sistema.dto.corDTOs.CorDTOforCorEntradaDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.LocalDate;

@Component
@Transactional
public class CorEntradasDTO extends MasterDTOImpl<CorEntradas, CorEntradasDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    //@NotBlank(message = ValidationsValues.NOT_BLANK_MESSAGE)
    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @PastOrPresent(message = ValidationsValues.PAST_OR_PRESENT_MESSAGE)
    private LocalDate dataEntrada;

    @PastOrPresent(message = ValidationsValues.PAST_OR_PRESENT_MESSAGE)
    private LocalDate dataFim;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Digits(integer = ValidationsValues.DIGITS_INTEGER, fraction = ValidationsValues.DIGITS_FRACTION,
            message = ValidationsValues.DIGITS_MESSAGE)
    private Double preco;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Digits(integer = ValidationsValues.DIGITS_INTEGER, fraction = ValidationsValues.DIGITS_FRACTION,
            message = ValidationsValues.DIGITS_MESSAGE)
    private Double quantidade;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private CorDTOforCorEntradaDTO cor = new CorDTOforCorEntradaDTO();

    public CorEntradasDTO() {
    }

    public CorEntradasDTO(CorEntradas entity) {
        this.id = entity.getId();
        this.dataEntrada = entity.getDataEntrada();
        this.dataFim = entity.getDataFim();
        this.preco = entity.getPreco();
        this.quantidade = entity.getQuantidade();
        this.cor = cor.makeDTO(entity.getCor());
        System.out.println(1);
    }

    @Override
    public CorEntradasDTO makeDTO(CorEntradas entity) {

        System.out.println(2);
        return new CorEntradasDTO(entity);
    }

    @Override
    public CorEntradas makeEntityfromDTO(CorEntradasDTO dto) {
        System.out.println(3);
        return new CorEntradas(dto.getId(), dto.getDataEntrada(), dto.getPreco(),
                dto.getQuantidade(), cor.makeEntityfromDTO(dto.getCor()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public CorDTOforCorEntradaDTO getCor() {
        return cor;
    }

    public void setCor(CorDTOforCorEntradaDTO cor) {
        this.cor = cor;
    }

}
