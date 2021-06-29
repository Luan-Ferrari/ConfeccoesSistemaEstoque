package br.net.luana.sistema.services.tipoServices;

import br.net.luana.sistema.domain.tipos.TipoAlca;
import br.net.luana.sistema.domain.tipos.TipoElastico;
import br.net.luana.sistema.repositories.tipoRepositories.TipoElasticoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoElasticoServiceImpl extends TipoServiceImpl<TipoElastico, Integer> implements TipoElasticoService{

    public TipoElasticoServiceImpl(TipoElasticoRepository tipoElasticoRepository) {
        super(tipoElasticoRepository);
    }
}
