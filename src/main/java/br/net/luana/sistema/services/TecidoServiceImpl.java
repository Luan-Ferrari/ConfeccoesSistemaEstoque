package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import br.net.luana.sistema.repositories.TecidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tecidoService")
@Transactional
public class TecidoServiceImpl extends MateriaPrimaServiceImpl<Tecido, Integer>
        implements TecidoService {

    private TecidoRepository tecidoRepository;

    public TecidoServiceImpl(TecidoRepository tecidoRepository) {
        super(tecidoRepository);
    }
}
