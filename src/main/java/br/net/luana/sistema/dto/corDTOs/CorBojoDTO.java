package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorBojo;
import br.net.luana.sistema.dto.CaixaBojoDTOforCorBojoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CorBojoDTO extends CorDTO<CorBojo, CorBojoDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private CaixaBojoDTOforCorBojoDTO caixaBojoDTOforCorBojoDTO = new CaixaBojoDTOforCorBojoDTO();

    private Integer bojoId;
    private String tipoBojo;
    private String tamanho;

    private List<CaixaBojoDTOforCorBojoDTO> caixas = new ArrayList<>();

    public CorBojoDTO() {
    }

    public CorBojoDTO(CorBojo entity) {
        super(entity);
        this.bojoId = entity.getBojo().getId();
        this.tipoBojo = entity.getBojo().getTipoBojo().getTipo();
        this.tamanho = entity.getBojo().getTipoBojo().getTamanho().getDescricao();
        this.caixas = caixaBojoDTOforCorBojoDTO.makeListDTO(entity.getCaixas());
    }

    @Override
    public CorBojoDTO makeDTO(CorBojo entity) { return new CorBojoDTO(entity); }

    public Integer getBojoId() {
        return bojoId;
    }

    public void setBojoId(Integer bojoId) {
        this.bojoId = bojoId;
    }

    public String getTipoBojo() {
        return tipoBojo;
    }

    public void setTipoBojo(String tipoBojo) {
        this.tipoBojo = tipoBojo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public List<CaixaBojoDTOforCorBojoDTO> getCaixas() {
        return caixas;
    }

    public void setCaixas(List<CaixaBojoDTOforCorBojoDTO> caixas) {
        this.caixas = caixas;
    }
}
