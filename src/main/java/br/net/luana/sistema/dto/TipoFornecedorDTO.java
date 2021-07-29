package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.TipoFornecedor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class TipoFornecedorDTO
        extends MasterDTOImpl<TipoFornecedor, TipoFornecedorDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_1,
            message = ValidationsValues.LENGTH)
    private String tipoFornecedor;

    private List<FornecedorDTO> fornecedores = new ArrayList<>();
    public TipoFornecedorDTO() {
    }

    public TipoFornecedorDTO(TipoFornecedor entity) {
        this.id = entity.getId();
        this.tipoFornecedor = entity.getTipoFornecedor();
    }

    @Override
    public TipoFornecedorDTO makeDTO(TipoFornecedor entity) {
        return new TipoFornecedorDTO(entity);
    }

    @Override
    public TipoFornecedor makeEntityfromDTO(TipoFornecedorDTO dto) {
        return new TipoFornecedor(dto.getId(), dto.getTipoFornecedor());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoFornecedor() {
        return tipoFornecedor;
    }

    public void setTipoFornecedor(String tipoFornecedor) {
        this.tipoFornecedor = tipoFornecedor;
    }
}
