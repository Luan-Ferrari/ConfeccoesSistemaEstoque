package br.net.luana.sistema.services.materiaPrimaService;

import br.net.luana.sistema.domain.materiasprimas.Bojo;
import br.net.luana.sistema.repositories.materiaPrimaRepositories.BojoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BojoServiceImpl extends MateriaPrimaServiceImpl<Bojo, Integer>
        implements BojoService {

    public BojoServiceImpl(BojoRepository bojoRepository) {
        super(bojoRepository);
    }
}
