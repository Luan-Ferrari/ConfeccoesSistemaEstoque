package br.net.luana.sistema.services.tipoServices;

import br.net.luana.sistema.domain.tipos.TipoLinha;
import br.net.luana.sistema.repositories.tipoRepositories.TipoLinhaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoLinhaServiceImpl extends TipoServiceImpl<TipoLinha, Integer> implements TipoLinhaService{

    public TipoLinhaServiceImpl(TipoLinhaRepository tipoLinhaRepository) {
        super(tipoLinhaRepository);
    }
}
