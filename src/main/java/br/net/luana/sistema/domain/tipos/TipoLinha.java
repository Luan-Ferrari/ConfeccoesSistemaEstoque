package br.net.luana.sistema.domain.tipos;

import br.net.luana.sistema.domain.materiasprimas.Linha;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoLinha extends Tipo implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "tipoLinha")
    private List<Linha> linhas = new ArrayList<>();

    public TipoLinha() {
    }

    public TipoLinha(Integer id, String tipo) {
        super(id, tipo);
    }

    public List<Linha> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<Linha> linhas) {
        this.linhas = linhas;
    }
}
