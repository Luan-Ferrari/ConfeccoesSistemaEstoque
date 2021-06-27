package br.net.luana.sistema.services.materiaPrimaService;

import br.net.luana.sistema.domain.materiasprimas.Renda;
import br.net.luana.sistema.repositories.materiaPrimaRepositories.RendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RendaServiceImpl extends MateriaPrimaServiceImpl<Renda, Integer>
        implements RendaService {

    public RendaServiceImpl(RendaRepository rendaRepository) {
        super(rendaRepository);
    }
}
