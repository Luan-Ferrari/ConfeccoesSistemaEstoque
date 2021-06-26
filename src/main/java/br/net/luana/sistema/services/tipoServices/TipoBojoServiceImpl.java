package br.net.luana.sistema.services.tipoServices;

import br.net.luana.sistema.domain.tipos.TipoBojo;
import br.net.luana.sistema.repositories.tipoRepositories.TipoBojoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoBojoServiceImpl extends TipoServiceImpl<TipoBojo, Integer> implements TipoBojoService{

    public TipoBojoServiceImpl(TipoBojoRepository tipoBojoRepository) {
        super(tipoBojoRepository);
    }

    @Override
    protected void updateData(TipoBojo updateEntity, TipoBojo entity) {
        super.updateData(updateEntity, entity);
        updateEntity.setTamanho(entity.getTamanho());
        updateEntity.setComposicao(entity.getComposicao());
    }
}
