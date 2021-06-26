package br.net.luana.sistema.services.corServices;

import br.net.luana.sistema.domain.cores.CorBojo;
import br.net.luana.sistema.repositories.corRepositories.CorBojoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorBojoServiceImpl extends CorServiceImpl<CorBojo, Integer>
        implements CorBojoService{

    public CorBojoServiceImpl(CorBojoRepository corBojoRepository) {
        super(corBojoRepository);
    }

    @Override
    protected void updateData(CorBojo updateEntity, CorBojo entity) {
        super.updateData(updateEntity, entity);
        updateEntity.setBojo(entity.getBojo());
        updateEntity.setCaixas(entity.getCaixas());
    }
}
