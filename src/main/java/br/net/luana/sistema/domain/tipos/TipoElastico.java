package br.net.luana.sistema.domain.tipos;

import br.net.luana.sistema.domain.materiasprimas.Elastico;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoElastico extends Tipo implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "tipoElastico")
    private List<Elastico> elasticos = new ArrayList<>();

    public TipoElastico() {
    }

    public TipoElastico(Integer id, String tipo) {
        super(id, tipo);
    }

    public List<Elastico> getElasticos() {
        return elasticos;
    }

    public void setElasticos(List<Elastico> elasticos) {
        this.elasticos = elasticos;
    }
}
