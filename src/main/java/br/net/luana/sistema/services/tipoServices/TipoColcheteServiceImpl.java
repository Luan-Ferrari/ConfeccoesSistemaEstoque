package br.net.luana.sistema.services.tipoServices;

import br.net.luana.sistema.domain.tipos.TipoColchete;
import br.net.luana.sistema.domain.tipos.TipoTecido;
import br.net.luana.sistema.repositories.tipoRepositories.TipoColcheteRepository;
import br.net.luana.sistema.repositories.tipoRepositories.TipoTecidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoColcheteServiceImpl extends TipoServiceImpl<TipoColchete, Integer> implements TipoColcheteService{

    public TipoColcheteServiceImpl(TipoColcheteRepository tipoColcheteRepository) {
        super(tipoColcheteRepository);
    }
}
