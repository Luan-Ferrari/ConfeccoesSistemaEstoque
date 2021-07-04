package br.net.luana.sistema.resources.corResources;

import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.dto.MasterDTOImpl;
import br.net.luana.sistema.resources.MasterResourceImpl;
import br.net.luana.sistema.services.corServices.CorService;

public abstract class CorResourceImpl<T extends Cor, D extends MasterDTOImpl, ID extends Integer>
        extends MasterResourceImpl<T, D, ID>
        implements CorResource<T, D, ID> {

    private CorService corService;

    public CorResourceImpl(CorService corService) {
        super(corService);
    }

}
