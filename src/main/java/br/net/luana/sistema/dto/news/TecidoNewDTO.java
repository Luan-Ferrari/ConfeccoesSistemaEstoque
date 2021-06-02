package br.net.luana.sistema.dto.news;

import br.net.luana.sistema.domain.materiasprimas.TecidoClasse;
import br.net.luana.sistema.domain.tipos.TipoTecido;

import javax.validation.constraints.NotEmpty;

public class TecidoNewDTO extends MateriaPrimaNewDTO{
    private static final long serialVersionUID = 1L;

    @NotEmpty (message = "Preenchimento obrigatório")
    private TipoTecido tipoTecido;

    @NotEmpty (message = "Preenchimento obrigatório")
    private TecidoClasse classe;

    public TecidoNewDTO() {
    }

    public TipoTecido getTipoTecido() {
        return tipoTecido;
    }

    public TecidoClasse getClasse() {
        return classe;
    }
}
