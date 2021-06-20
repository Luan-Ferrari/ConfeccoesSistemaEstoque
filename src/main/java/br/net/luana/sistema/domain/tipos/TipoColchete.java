package br.net.luana.sistema.domain.tipos;

import br.net.luana.sistema.domain.materiasprimas.Colchete;
import br.net.luana.sistema.domain.materiasprimas.Tecido;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoColchete extends Tipo implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "tipoColchete")
    private List<Colchete> colchetes = new ArrayList<>();

    public TipoColchete() {
    }

    public TipoColchete(Integer id, String tipo) {
        super(id, tipo);
    }

    public List<Colchete> getColchetes() {
        return colchetes;
    }

    public void setColchetes(List<Colchete> colchetes) { this.colchetes = colchetes;
    }
}
