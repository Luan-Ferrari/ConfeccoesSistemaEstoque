package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.materiasprimas.Tecido;

import org.springframework.stereotype.Component;

@Component
public class TecidoDTO extends MateriaPrimaDTO<Tecido, TecidoDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private Integer tipoTecidoId;
    private String tipoTecido;

    private Integer tecidoClasseId;
    private String tecidoClasse;

    public TecidoDTO() {
    }

    public TecidoDTO(Tecido entity) {
        super(entity);
        this.tipoTecidoId = entity.getTipoTecido().getId();
        this.tipoTecido = entity.getTipoTecido().getTipo();
        this.tecidoClasseId = entity.getClasse().getId();
        this.tecidoClasse = entity.getClasse().getNome();
    }

    @Override
    public TecidoDTO makeDTO(Tecido entity) {
        return new TecidoDTO(entity);
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
