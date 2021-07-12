package br.net.luana.sistema.dto.tipoDTOs;

import br.net.luana.sistema.domain.tipos.TipoAlca;
import br.net.luana.sistema.dto.ValidationsValues;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class TipoAlcaDTO extends TipoDTO<TipoAlca, TipoAlcaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_1,
            message = ValidationsValues.LENGTH)
    private String tipo;

    public TipoAlcaDTO() {
    }

    public TipoAlcaDTO(TipoAlca entity) {
        this.id = entity.getId();
        this.tipo = entity.getTipo();
    }

    @Override
    public TipoAlcaDTO makeDTO(TipoAlca entity) {
        return new TipoAlcaDTO(entity);
    }

    @Override
    public TipoAlca makeEntityfromDTO(TipoAlcaDTO dto) {
        return new TipoAlca(dto.getId(), dto.getTipo());
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
