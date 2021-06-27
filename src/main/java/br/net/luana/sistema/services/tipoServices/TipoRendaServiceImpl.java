package br.net.luana.sistema.services.tipoServices;

import br.net.luana.sistema.domain.tipos.TipoRenda;
import br.net.luana.sistema.repositories.tipoRepositories.TipoRendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoRendaServiceImpl extends TipoServiceImpl<TipoRenda, Integer> implements TipoRendaService{

    public TipoRendaServiceImpl(TipoRendaRepository tipoRendaRepository) {
        super(tipoRendaRepository);
    }
}
