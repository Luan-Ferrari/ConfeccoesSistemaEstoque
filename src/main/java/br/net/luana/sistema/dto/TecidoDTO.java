package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

@Component
public class TecidoDTO extends MateriaPrimaDTO {

    @JsonIgnore
    private Integer tipoTecidoId;
    private String tipoTecido;

    @JsonIgnore
    private Integer tecidoClasseId;
    private String tecidoClasse;

    public TecidoDTO() {
    }


    public Integer getTipoTecidoId() {
        return tipoTecidoId;
    }

    public void setTipoTecidoId(Integer tipoTecidoId) {
        this.tipoTecidoId = tipoTecidoId;
    }

    public String getTipoTecido() {
        return tipoTecido;
    }

    public void setTipoTecido(String tipoTecido) {
        this.tipoTecido = tipoTecido;
    }

    public Integer getTecidoClasseId() {
        return tecidoClasseId;
    }

    public void setTecidoClasseId(Integer tecidoClasseId) {
        this.tecidoClasseId = tecidoClasseId;
    }

    public String getTecidoClasse() {
        return tecidoClasse;
    }

    public void setTecidoClasse(String tecidoClasse) {
        this.tecidoClasse = tecidoClasse;
    }
}
