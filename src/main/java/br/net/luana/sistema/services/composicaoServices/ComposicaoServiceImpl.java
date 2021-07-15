package br.net.luana.sistema.services.composicaoServices;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.domain.composicoes.ComposicaoFio;
import br.net.luana.sistema.repositories.composicoes.ComposicaoFioRepository;
import br.net.luana.sistema.repositories.composicoes.ComposicaoRepository;
import br.net.luana.sistema.services.MasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class ComposicaoServiceImpl extends MasterServiceImpl<Composicao, Integer>
        implements ComposicaoService {

    @Autowired
    private ComposicaoRepository composicaoRepository;
    @Autowired
    private ComposicaoFioRepository composicaoFioRepository;

    public ComposicaoServiceImpl(ComposicaoRepository composicaoRepository) {
        super(composicaoRepository);
    }

    @Override
    public Composicao save(Composicao entity) {
        for(ComposicaoFio cf : entity.getItensFios()) {
            System.out.println(cf.getFio());
            System.out.println(cf.getComposicao().getNumero());
            System.out.println(cf.getPorcentagem());
        }
        composicaoFioRepository.saveAll(new ArrayList<>(entity.getItensFios()));
        return composicaoRepository.save(entity);
    }

    @Override
    protected void updateData(Composicao updateEntity, Composicao entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setNumero(entity.getNumero());
        updateEntity.setItensFios(entity.getItensFios());
    }
}
