package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

@Component
public class TecidoDTO extends MateriaPrimaDTO<Tecido> {

    @JsonIgnore
    private Integer tipoTecidoId;
    private String tipoTecido;

    @JsonIgnore
    private Integer tecidoClasseId;
    private String tecidoClasse;

    public TecidoDTO() {
    }

    @Override
    public MateriaPrimaDTO makeDTO(Tecido entity) {
        super.makeDTO(entity);
        this.setTipoTecidoId(entity.getTipoTecido().getId());
        this.setTipoTecido(entity.getTipoTecido().getTipo());
        this.setTecidoClasseId(entity.getClasse().getId());
        this.setTecidoClasse(entity.getClasse().getNome());
        return this;
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
