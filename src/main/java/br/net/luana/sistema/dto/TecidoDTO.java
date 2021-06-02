package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.domain.tipos.TipoTecido;
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

    public TecidoDTO(MateriaPrima obj, Integer tipoTecidoId, String tipoTecido, Integer tecidoClasseId, String tecidoClasse) {
        super(obj);
        this.tipoTecido = tipoTecido;
        this.tecidoClasseId = tecidoClasseId;
        this.tecidoClasse = tecidoClasse;
    }
}
