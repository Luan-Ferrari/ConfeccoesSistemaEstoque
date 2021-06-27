package br.net.luana.sistema.services.corServices;

import br.net.luana.sistema.domain.cores.CorAlca;
import br.net.luana.sistema.repositories.corRepositories.CorAlcaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorAlcaServiceImpl extends CorServiceImpl<CorAlca, Integer>
        implements CorAlcaService{

    public CorAlcaServiceImpl(CorAlcaRepository corAlcaRepository) {
        super(corAlcaRepository);
    }

    @Override
    protected void updateData(CorAlca updateEntity, CorAlca entity) {
        super.updateData(updateEntity, entity);
        updateEntity.setAlca(entity.getAlca());
    }
}
