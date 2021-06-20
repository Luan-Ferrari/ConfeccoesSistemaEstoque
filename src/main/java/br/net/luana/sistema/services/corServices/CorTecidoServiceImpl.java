package br.net.luana.sistema.services.corServices;

import br.net.luana.sistema.domain.cores.CorTecido;
import br.net.luana.sistema.repositories.corRepositories.CorTecidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorTecidoServiceImpl extends CorServiceImpl<CorTecido, Integer>
        implements CorTecidoService{

    private CorTecidoRepository corTecidoRepository;

    public CorTecidoServiceImpl(CorTecidoRepository corTecidoRepository) {
        super(corTecidoRepository);
    }

    @Override
    protected void updateData(CorTecido updateEntity, CorTecido entity) {
        super.updateData(updateEntity, entity);
        updateEntity.setTecido(entity.getTecido());
        updateEntity.setComposicao(entity.getComposicao());
    }
}
