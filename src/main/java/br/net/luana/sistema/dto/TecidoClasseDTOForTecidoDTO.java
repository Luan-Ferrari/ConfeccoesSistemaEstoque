package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.TecidoClasse;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class TecidoClasseDTOForTecidoDTO extends MasterDTOImpl<TecidoClasse, TecidoClasseDTOForTecidoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    public TecidoClasseDTOForTecidoDTO() {
    }

    public TecidoClasseDTOForTecidoDTO(TecidoClasse entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    @Override
    public TecidoClasseDTOForTecidoDTO makeDTO(TecidoClasse entity) {
        return new TecidoClasseDTOForTecidoDTO(entity);
    }

    @Override
    public TecidoClasse makeEntityfromDTO(TecidoClasseDTOForTecidoDTO dto) {
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
}
