package br.net.luana.sistema.resources.tipoResources;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.domain.tipos.Tipo;
import br.net.luana.sistema.dto.MasterDTOImpl;
import br.net.luana.sistema.resources.MasterResourceImpl;
import br.net.luana.sistema.services.materiaPrimaService.MateriaPrimaService;
import br.net.luana.sistema.services.tipoServices.TipoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class TipoResourceImpl<T extends Tipo, D extends MasterDTOImpl, ID extends Integer>
        extends MasterResourceImpl<T, D, ID>
        implements TipoResource<T, D, ID> {

    public TipoResourceImpl(TipoService tipoService) {
        super(tipoService);
    }

}
