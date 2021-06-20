package br.net.luana.sistema.services.tipoServices;

import br.net.luana.sistema.domain.tipos.TipoTecido;
import br.net.luana.sistema.repositories.tipoRepositories.TipoRepository;
import br.net.luana.sistema.repositories.tipoRepositories.TipoTecidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoTecidoImpl extends TipoServiceImpl<TipoTecido, Integer> implements TipoTecidoService{

    public TipoTecidoImpl(TipoTecidoRepository tipoTecidoRepository) {
        super(tipoTecidoRepository);
    }
}
