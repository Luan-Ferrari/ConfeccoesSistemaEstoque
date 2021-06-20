package br.net.luana.sistema.services.corServices;

import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.services.MasterService;

public interface CorService<T extends Cor, ID extends Integer>
        extends MasterService<T, ID> {
}
