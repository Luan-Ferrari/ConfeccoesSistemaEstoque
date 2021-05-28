package br.net.luana.sistema.domain.tipos;

import br.net.luana.sistema.domain.materias.Tecido;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoTecido extends Tipo {

    @OneToMany(mappedBy = "tipoTecido")
    private List<Tecido> tecidos = new ArrayList<>();

    public TipoTecido() {
    }

    public TipoTecido(Integer id, String tipo) {
        super(id, tipo);
    }

    public List<Tecido> getTecidos() {
        return tecidos;
    }

    public void setTecidos(List<Tecido> tecidos) {
        this.tecidos = tecidos;
    }
}
