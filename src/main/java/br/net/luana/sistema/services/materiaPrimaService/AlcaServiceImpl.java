package br.net.luana.sistema.services.materiaPrimaService;

import br.net.luana.sistema.domain.materiasprimas.Alca;
import br.net.luana.sistema.repositories.materiaPrimaRepositories.AlcaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlcaServiceImpl extends MateriaPrimaServiceImpl<Alca, Integer>
        implements AlcaService {

    public AlcaServiceImpl(AlcaRepository alcaRepository) {
        super(alcaRepository);
    }
}
