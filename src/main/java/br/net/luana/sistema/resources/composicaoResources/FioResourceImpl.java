package br.net.luana.sistema.resources.composicaoResources;

import br.net.luana.sistema.domain.composicoes.Fio;
import br.net.luana.sistema.dto.composicoesDTOs.FioDTO;
import br.net.luana.sistema.resources.MasterResourceImpl;
import br.net.luana.sistema.services.composicaoServices.FioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fio")
public class FioResourceImpl extends MasterResourceImpl<Fio, FioDTO, Integer>
        implements FioResource {


    public FioResourceImpl(FioService fioService) {
        super(fioService);
    }
}
