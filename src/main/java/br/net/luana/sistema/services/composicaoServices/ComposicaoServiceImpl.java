package br.net.luana.sistema.services.composicaoServices;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.repositories.composicoes.ComposicaoRepository;
import br.net.luana.sistema.services.MasterServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ComposicaoServiceImpl extends MasterServiceImpl<Composicao, Integer>
        implements ComposicaoService {

    public ComposicaoServiceImpl(ComposicaoRepository composicaoRepository) {
        super(composicaoRepository);
    }

    @Override
    protected void updateData(Composicao updateEntity, Composicao entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setNumero(entity.getNumero());
        updateEntity.setItensFios(entity.getItensFios());
    }
}
