package br.net.luana.sistema.resources.composicaoResources;

import br.net.luana.sistema.domain.composicoes.ModoLavar;
import br.net.luana.sistema.dto.composicoesDTOs.ModoLavarDTO;
import br.net.luana.sistema.resources.MasterResourceImpl;
import br.net.luana.sistema.services.composicaoServices.ModoLavarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modoLavar")
public class ModoLavarResourceImpl extends MasterResourceImpl<ModoLavar, ModoLavarDTO, Integer>
        implements ModoLavarResource {


    public ModoLavarResourceImpl(ModoLavarService modoLavarService) {
        super(modoLavarService);
    }
}
