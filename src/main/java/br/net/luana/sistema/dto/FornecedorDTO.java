package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.TipoFornecedor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class FornecedorDTO
        extends MasterDTOImpl<Fornecedor, FornecedorDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;
    //CLASSE IMCOMPLETA PRECISA TERMINAR


    private Integer id;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_1,
            message = ValidationsValues.LENGTH)
    private String tipoFornecedor;

    private List<FornecedorDTO> fornecedores = new ArrayList<>();
    public FornecedorDTO() {
    }

    public FornecedorDTO(TipoFornecedor entity) {
        this.id = entity.getId();
        this.tipoFornecedor = entity.getTipoFornecedor();
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

    @Override
    public FornecedorDTO makeDTO(Fornecedor entity) {
        return null;
    }

    @Override
    public Fornecedor makeEntityfromDTO(FornecedorDTO dto) {
        return null;
    }
}
