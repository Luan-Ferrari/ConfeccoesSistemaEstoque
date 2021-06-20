package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.TecidoClasse;
import br.net.luana.sistema.dto.TecidoClasseDTO;
import br.net.luana.sistema.services.MasterService;
import br.net.luana.sistema.services.TecidoClasseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/tecidoClasse")
public class TecidoClasseResourceImpl
        extends MasterResourceImpl<TecidoClasse, TecidoClasseDTO, Integer>
        implements TecidoClasseResource{

    public TecidoClasseResourceImpl(TecidoClasseService tecidoClasseService) {
        super(tecidoClasseService);
    }
}
