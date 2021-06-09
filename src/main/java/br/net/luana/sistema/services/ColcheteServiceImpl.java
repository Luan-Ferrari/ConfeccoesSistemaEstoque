package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.materiasprimas.Colchete;
import br.net.luana.sistema.dto.ColcheteDTO;
import br.net.luana.sistema.repositories.ColcheteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("colcheteService")
@Transactional
public class ColcheteServiceImpl extends MateriaPrimaServiceImpl<Colchete, ColcheteDTO, Integer>
        implements ColcheteService {

    @Autowired
    private ColcheteDTO colcheteDTO;
    private ColcheteRepository colcheteRepository;

    public ColcheteServiceImpl(ColcheteRepository colcheteRepository) {
        super(colcheteRepository);
    }
}
