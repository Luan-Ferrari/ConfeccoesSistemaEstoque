package br.net.luana.sistema.services.materiaPrimaService;

import br.net.luana.sistema.domain.materiasprimas.Linha;
import br.net.luana.sistema.repositories.materiaPrimaRepositories.LinhaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LinhaServiceImpl extends MateriaPrimaServiceImpl<Linha, Integer>
        implements LinhaService {

    public LinhaServiceImpl(LinhaRepository linhaRepository) {
        super(linhaRepository);
    }
}
