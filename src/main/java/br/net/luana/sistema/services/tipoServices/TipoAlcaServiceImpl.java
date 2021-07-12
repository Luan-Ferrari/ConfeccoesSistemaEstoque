package br.net.luana.sistema.services.tipoServices;

import br.net.luana.sistema.domain.tipos.TipoAlca;
import br.net.luana.sistema.repositories.tipoRepositories.TipoAlcaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoAlcaServiceImpl extends TipoServiceImpl<TipoAlca, Integer> implements TipoAlcaService{


    public TipoAlcaServiceImpl(TipoAlcaRepository tipoAlcaRepository) {
        super(tipoAlcaRepository);
    }
}
