package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.TecidoClasse;
import br.net.luana.sistema.dto.materiaPrimaDTOs.TecidoDTO;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class TecidoClasseDTO extends MasterDTOImpl<TecidoClasse, TecidoClasseDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private TecidoDTO tecidoDTO = new TecidoDTO();

    private Integer id;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_1,
            message = ValidationsValues.LENGTH)
    private String nome;


    private List<TecidoDTO> tecidos = new ArrayList<>();

    public TecidoClasseDTO() {
    }

    public TecidoClasseDTO(TecidoClasse entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.tecidos = tecidoDTO.makeListDTO(entity.getTecidos());
    }

    @Override
    public TecidoClasseDTO makeDTO(TecidoClasse entity) {
        return new TecidoClasseDTO(entity);
    }

    @Override
    public TecidoClasse makeEntityfromDTO(TecidoClasseDTO dto) {
        return new TecidoClasse(dto.getId(), dto.getNome());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TecidoDTO> getTecidos() {
        return tecidos;
    }

    public void setTecidos(List<TecidoDTO> tecidos) {
        this.tecidos = tecidos;
    }
}
