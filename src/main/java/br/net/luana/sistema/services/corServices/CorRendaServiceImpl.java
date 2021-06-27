package br.net.luana.sistema.services.corServices;

import br.net.luana.sistema.domain.cores.CorRenda;
import br.net.luana.sistema.repositories.corRepositories.CorRendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorRendaServiceImpl extends CorServiceImpl<CorRenda, Integer>
        implements CorRendaService{

    public CorRendaServiceImpl(CorRendaRepository corRendaRepository) {
        super(corRendaRepository);
    }

    @Override
    protected void updateData(CorRenda updateEntity, CorRenda entity) {
        super.updateData(updateEntity, entity);
        updateEntity.setRenda(entity.getRenda());
    }
}
