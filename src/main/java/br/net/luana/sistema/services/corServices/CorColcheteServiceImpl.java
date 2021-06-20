package br.net.luana.sistema.services.corServices;

import br.net.luana.sistema.domain.cores.CorColchete;
import br.net.luana.sistema.domain.cores.CorTecido;
import br.net.luana.sistema.repositories.corRepositories.CorColcheteRepository;
import br.net.luana.sistema.repositories.corRepositories.CorTecidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorColcheteServiceImpl extends CorServiceImpl<CorColchete, Integer>
        implements CorColcheteService{

    private CorColcheteRepository corColcheteRepository;

    public CorColcheteServiceImpl(CorColcheteRepository corColcheteRepository) {
        super(corColcheteRepository);
    }

    @Override
    protected void updateData(CorColchete updateEntity, CorColchete entity) {
        super.updateData(updateEntity, entity);
        updateEntity.setColchete(entity.getColchete());
    }
}
