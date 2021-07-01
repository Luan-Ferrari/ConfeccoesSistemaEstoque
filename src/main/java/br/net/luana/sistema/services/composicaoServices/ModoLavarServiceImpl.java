package br.net.luana.sistema.services.composicaoServices;

import br.net.luana.sistema.domain.composicoes.ModoLavar;
import br.net.luana.sistema.repositories.composicoes.ModoLavarRepository;
import br.net.luana.sistema.services.MasterServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModoLavarServiceImpl extends MasterServiceImpl<ModoLavar, Integer>
        implements ModoLavarService {

    public ModoLavarServiceImpl(ModoLavarRepository modoLavarRepository) {
        super(modoLavarRepository);
    }

    @Override
    protected void updateData(ModoLavar updateEntity, ModoLavar entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setCategoria(entity.getCategoria());
        updateEntity.setDescricao(entity.getDescricao());
        updateEntity.setDescricaoImagem(entity.getDescricaoImagem());
    }
}
