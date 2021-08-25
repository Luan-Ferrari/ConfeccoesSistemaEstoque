package br.net.luana.sistema.resources.corResources;

import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.dto.MasterDTO;
import br.net.luana.sistema.resources.MasterResource;

public interface CorResource<T extends Cor, D extends MasterDTO, ID extends Integer>
        extends MasterResource<T, D, ID> {

}
