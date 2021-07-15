package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.dto.MasterDTOImpl;
import br.net.luana.sistema.dto.ValidationsValues;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Component
public class CorDTO <T extends Cor, D extends CorDTO, ID extends Integer>
        extends MasterDTOImpl<T, D, ID>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_1,
            message = ValidationsValues.LENGTH)
    private String referenciaNaFabrica;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_1,
            message = ValidationsValues.LENGTH)
    private String nome;

    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_3,
            message = ValidationsValues.LENGTH)
    private String observacoes;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Digits(integer = ValidationsValues.DIGITS_INTEGER, fraction = ValidationsValues.DIGITS_FRACTION,
            message = ValidationsValues.DIGITS_MESSAGE)
    private Double quantidadeEstoque;


    public CorDTO(){ }

    public CorDTO(T entity) {
        this.id = entity.getId();
        this.referenciaNaFabrica = entity.getReferenciaNaFabrica();
        this.nome = entity.getNome();
        this.observacoes = entity.getObservacoes();
        this.quantidadeEstoque = entity.getQuantidadeEstoque();
    }

    @Override
    public D makeDTO(T entity) {
        return (D) new CorDTO<T, D, ID>(entity);
    }

    @Override
    public T makeEntityfromDTO(D dto) {
        return (T) new Cor(dto.getId(), dto.getReferenciaNaFabrica(), dto.getNome(),
                dto.getObservacoes(), dto.getQuantidadeEstoque());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenciaNaFabrica() {
        return referenciaNaFabrica;
    }

    public void setReferenciaNaFabrica(String referenciaNaFabrica) {
        this.referenciaNaFabrica = referenciaNaFabrica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
