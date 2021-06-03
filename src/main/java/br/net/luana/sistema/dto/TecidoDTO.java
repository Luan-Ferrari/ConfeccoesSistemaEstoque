package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TecidoDTO extends MateriaPrimaDTO{

    @JsonIgnore
    private Integer tipoTecidoId;
    private String tipoTecido;

    @JsonIgnore
    private Integer tecidoClasseId;
    private String tecidoClasse;

    public TecidoDTO() {
    }

    public TecidoDTO(Tecido obj) {
        super(obj);
        this.tipoTecidoId = obj.getTipoTecido().getId();
        this.tipoTecido = obj.getTipoTecido().getTipo();
        this.tecidoClasseId = obj.getClasse().getId();
        this.tecidoClasse = obj.getClasse().getNome();
    }
}
