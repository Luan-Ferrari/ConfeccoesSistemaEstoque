package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.CaixaBojo;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CaixaBojoDTOforCorBojoDTO extends MasterDTOImpl<CaixaBojo, CaixaBojoDTOforCorBojoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nomeCaixa;

    public CaixaBojoDTOforCorBojoDTO() {
    }

    public CaixaBojoDTOforCorBojoDTO(CaixaBojo entity) {
        this.id = entity.getId();
        this.nomeCaixa = entity.getNomeCaixa();
    }

    @Override
    public CaixaBojoDTOforCorBojoDTO makeDTO(CaixaBojo entity) { return new CaixaBojoDTOforCorBojoDTO(entity); }

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

}
