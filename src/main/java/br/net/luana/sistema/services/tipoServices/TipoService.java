package br.net.luana.sistema.services.tipoServices;

import br.net.luana.sistema.domain.tipos.Tipo;
import br.net.luana.sistema.services.MasterService;

public interface TipoService <T extends Tipo, ID extends Integer>
        extends MasterService<T, ID> {
}
