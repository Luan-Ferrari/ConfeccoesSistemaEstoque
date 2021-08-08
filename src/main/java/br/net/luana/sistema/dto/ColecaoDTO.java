package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.Colecao;
import br.net.luana.sistema.domain.ColecaoCor;
import br.net.luana.sistema.dto.corDTOs.CorDTO;
import br.net.luana.sistema.services.validation.ColecaoInsert;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ColecaoInsert
@Component
public class ColecaoDTO
        extends MasterDTOImpl<Colecao, ColecaoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private CorDTO corDTO = new CorDTO();

    private Integer id;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private String nome;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private Integer ano;

    private List<CorDTO> cores = new ArrayList<>();

    private List<Integer> numeros = new ArrayList<>();

    public ColecaoDTO(){}

    public ColecaoDTO(Colecao entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.ano = entity.getAno();
        this.cores = corDTO.makeListDTO(entity.getCores());
        this.numeros = entity.getNumeros();
    }

    @Override
    public ColecaoDTO makeDTO(Colecao entity) {
        return new ColecaoDTO(entity);
    }

    @Override
    public Colecao makeEntityfromDTO(ColecaoDTO dto) {
        try {
            Colecao colecao = new Colecao();
            colecao.setId(dto.getId());
            colecao.setNome(dto.getNome());
            colecao.setAno(dto.getAno());
            for (int i = 0; i < cores.size(); i++) {
                ColecaoCor colecaoCor = new ColecaoCor(colecao,
                        corDTO.makeEntityfromDTO(cores.get(i)),
                        numeros.get(i));
                colecao.getItensCores().add(colecaoCor);
            }
            return colecao;
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException(cores.size() + " cores para "
            + numeros.size() + " numeros");
        }
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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public List<CorDTO> getCores() {
        return cores;
    }

    public void setCores(List<CorDTO> cores) {
        this.cores = cores;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }
}
