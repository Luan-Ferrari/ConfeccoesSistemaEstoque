package br.net.luana.sistema.services.tipoServices;

import br.net.luana.sistema.domain.tipos.TipoTecido;
import br.net.luana.sistema.repositories.tipoRepositories.TipoRepository;
import br.net.luana.sistema.repositories.tipoRepositories.TipoTecidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoTecidoServiceImpl extends TipoServiceImpl<TipoTecido, Integer> implements TipoTecidoService{

    public TipoTecidoServiceImpl(TipoTecidoRepository tipoTecidoRepository) {
        super(tipoTecidoRepository);
    }
}
