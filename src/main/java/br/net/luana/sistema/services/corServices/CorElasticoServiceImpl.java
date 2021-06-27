package br.net.luana.sistema.services.corServices;

import br.net.luana.sistema.domain.cores.CorElastico;
import br.net.luana.sistema.repositories.corRepositories.CorElasticoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorElasticoServiceImpl extends CorServiceImpl<CorElastico, Integer>
        implements CorElasticoService{

    public CorElasticoServiceImpl(CorElasticoRepository corElasticoRepository) {
        super(corElasticoRepository);
    }

    @Override
    protected void updateData(CorElastico updateEntity, CorElastico entity) {
        super.updateData(updateEntity, entity);
        updateEntity.setElastico(entity.getElastico());
    }
}
