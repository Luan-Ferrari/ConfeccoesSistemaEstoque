package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.CaixaBojo;
import br.net.luana.sistema.dto.corDTOs.CorBojoDTO;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class CaixaBojoDTO extends MasterDTOImpl<CaixaBojo, CaixaBojoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private CorBojoDTO corBojoDTO = new CorBojoDTO();

    private Integer id;
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
