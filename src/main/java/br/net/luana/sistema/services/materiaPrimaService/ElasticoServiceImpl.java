package br.net.luana.sistema.services.materiaPrimaService;

import br.net.luana.sistema.domain.materiasprimas.Elastico;
import br.net.luana.sistema.repositories.materiaPrimaRepositories.ElasticoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ElasticoServiceImpl extends MateriaPrimaServiceImpl<Elastico, Integer>
        implements ElasticoService {

    public ElasticoServiceImpl(ElasticoRepository elasticoRepository) {
        super(elasticoRepository);
    }
}
