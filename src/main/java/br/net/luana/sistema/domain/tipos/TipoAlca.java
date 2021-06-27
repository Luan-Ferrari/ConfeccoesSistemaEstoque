package br.net.luana.sistema.domain.tipos;

import br.net.luana.sistema.domain.materiasprimas.Alca;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoAlca extends Tipo implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "tipoAlca")
    private List<Alca> alcas = new ArrayList<>();

    public TipoAlca() {
    }

    public TipoAlca(Integer id, String tipo) {
        super(id, tipo);
    }

    public List<Alca> getAlcas() {
        return alcas;
    }

    public void setAlcas(List<Alca> alcas) {
        this.alcas = alcas;
    }
}

