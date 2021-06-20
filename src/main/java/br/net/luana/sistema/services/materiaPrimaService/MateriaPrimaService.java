package br.net.luana.sistema.services.materiaPrimaService;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.services.MasterService;

public interface MateriaPrimaService<T extends MateriaPrima, ID extends Integer>
        extends MasterService<T, ID> {
}
