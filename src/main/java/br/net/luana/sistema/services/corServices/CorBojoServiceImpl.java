package br.net.luana.sistema.services.corServices;

import br.net.luana.sistema.domain.CaixaBojo;
import br.net.luana.sistema.domain.cores.CorBojo;
import br.net.luana.sistema.repositories.corRepositories.CorBojoRepository;
import br.net.luana.sistema.services.CaixaBojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorBojoServiceImpl extends CorServiceImpl<CorBojo, Integer>
        implements CorBojoService{

    @Autowired
    private CaixaBojoService caixaBojoService;
    @Autowired
    private CorBojoRepository corBojoRepository;

    public CorBojoServiceImpl(CorBojoRepository corBojoRepository) {
        super(corBojoRepository);
    }

    @Override
    public CorBojo save(CorBojo entity) {
        entity = corBojoRepository.save(entity);
        for (CaixaBojo cb : entity.getCaixas()) {
            cb = caixaBojoService.findById(cb.getId());
            cb.getCoresArmazenadas().add(entity);
            caixaBojoService.save(cb);
        }
        return entity;
    }

    @Override
    protected void updateData(CorBojo updateEntity, CorBojo entity) {
        super.updateData(updateEntity, entity);
        updateEntity.setBojo(entity.getBojo());
        updateEntity.setCaixas(entity.getCaixas());
    }
}
