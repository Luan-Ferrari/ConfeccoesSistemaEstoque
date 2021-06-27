package br.net.luana.sistema.services.corServices;

import br.net.luana.sistema.domain.cores.CorLinha;
import br.net.luana.sistema.repositories.corRepositories.CorLinhaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorLinhaServiceImpl extends CorServiceImpl<CorLinha, Integer>
        implements CorLinhaService{

    public CorLinhaServiceImpl(CorLinhaRepository corLinhaRepository) {
        super(corLinhaRepository);
    }

    @Override
    protected void updateData(CorLinha updateEntity, CorLinha entity) {
        super.updateData(updateEntity, entity);
        updateEntity.setLinha(entity.getLinha());
    }
}
