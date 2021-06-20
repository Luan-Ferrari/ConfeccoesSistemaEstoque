package br.net.luana.sistema.domain.tipos;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoTecido extends Tipo implements Serializable {
    private static final long serialVersionUID = 1L;

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
