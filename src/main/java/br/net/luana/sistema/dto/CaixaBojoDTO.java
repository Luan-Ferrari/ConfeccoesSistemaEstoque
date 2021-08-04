package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.CaixaBojo;
import br.net.luana.sistema.dto.corDTOs.CorBojoDTO;
import br.net.luana.sistema.services.validation.CaixaBojoInsert;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@CaixaBojoInsert
@Component
public class CaixaBojoDTO extends MasterDTOImpl<CaixaBojo, CaixaBojoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private CorBojoDTO corBojoDTO = new CorBojoDTO();

    private Integer id;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_1, message = ValidationsValues.LENGTH)
    private String nomeCaixa;

    private List<CorBojoDTO> coresArmazenadas = new ArrayList<>();

    public CaixaBojoDTO() {
    }

    public CaixaBojoDTO(CaixaBojo entity) {
        this.id = entity.getId();
        this.nomeCaixa = entity.getNomeCaixa();
        this.coresArmazenadas = corBojoDTO.makeListDTO(entity.getCoresArmazenadas());
    }

    @Override
    public CaixaBojoDTO makeDTO(CaixaBojo entity) { return new CaixaBojoDTO(entity); }

    @Override
    public CaixaBojo makeEntityfromDTO(CaixaBojoDTO dto) {
        return new CaixaBojo(dto.getId(), dto.getNomeCaixa());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCaixa() {
        return nomeCaixa;
    }

    public void setNomeCaixa(String nomeCaixa) {
        this.nomeCaixa = nomeCaixa;
    }

    public List<CorBojoDTO> getCoresArmazenadas() {
        return coresArmazenadas;
    }

    public void setCoresArmazenadas(List<CorBojoDTO> coresArmazenadas) {
        this.coresArmazenadas = coresArmazenadas;
    }
}
