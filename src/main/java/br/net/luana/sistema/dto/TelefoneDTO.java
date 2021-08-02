package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.Telefone;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Component
public class TelefoneDTO
        extends MasterDTOImpl<Telefone, TelefoneDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private String ddd;

    @NotBlank (message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private String telefone;

    private String ramal;

    public TelefoneDTO() {
    }

    public TelefoneDTO(Telefone entity) {
        this.id = entity.getId();
        this.ddd = entity.getDdd();
        this.telefone = entity.getTelefone();
        this.ramal = entity.getRamal();
    }

    @Override
    public TelefoneDTO makeDTO(Telefone entity) {
        return new TelefoneDTO(entity);
    }

    @Override
    public Telefone makeEntityfromDTO(TelefoneDTO dto) {
        return new Telefone(dto.getId(), dto.getDdd(), dto.getTelefone(), dto.getRamal(),
                null, null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

}
