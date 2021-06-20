package br.net.luana.sistema.resources.materiaPrimaResources;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.dto.MasterDTO;
import br.net.luana.sistema.resources.MasterResource;

public interface MateriaPrimaResource<T extends MateriaPrima, D extends MasterDTO, ID extends Integer>
        extends MasterResource<T, D, ID> {

}
