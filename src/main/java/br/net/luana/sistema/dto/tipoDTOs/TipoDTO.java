package br.net.luana.sistema.dto.tipoDTOs;

import br.net.luana.sistema.domain.tipos.Tipo;
import br.net.luana.sistema.dto.MasterDTOImpl;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class TipoDTO<T extends Tipo, D extends TipoDTO, ID extends Integer>
        extends MasterDTOImpl<T, D, ID>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String tipo;

    public TipoDTO() {
    }

    public TipoDTO(Tipo entity) {
        this.id = entity.getId();
        this.tipo = entity.getTipo();
    }

    @Override
    public D makeDTO(T entity) {
        return (D) new TipoDTO<T, D, ID>(entity);
    }

    @Override
    public T makeEntityfromDTO(D dto) {
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
