package br.net.luana.sistema.resources.tipoResources;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.domain.tipos.Tipo;
import br.net.luana.sistema.dto.MasterDTO;
import br.net.luana.sistema.resources.MasterResource;

public interface TipoResource<T extends Tipo, D extends MasterDTO, ID extends Integer>
        extends MasterResource<T, D, ID> {

}
