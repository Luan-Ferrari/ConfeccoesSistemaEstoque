package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.materiasprimas.Colchete;
import br.net.luana.sistema.repositories.ColcheteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ColcheteServiceImpl extends MateriaPrimaServiceImpl<Colchete, Integer>
        implements ColcheteService2 {

    public ColcheteServiceImpl(ColcheteRepository colcheteRepository) {
        super(colcheteRepository);
    }
}
