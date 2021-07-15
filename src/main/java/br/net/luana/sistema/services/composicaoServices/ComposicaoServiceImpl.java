package br.net.luana.sistema.services.composicaoServices;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.domain.composicoes.ComposicaoFio;
import br.net.luana.sistema.repositories.composicoes.ComposicaoFioRepository;
import br.net.luana.sistema.repositories.composicoes.ComposicaoRepository;
import br.net.luana.sistema.services.MasterServiceImpl;
import br.net.luana.sistema.services.exceptions.PorcentagemComposicaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ComposicaoServiceImpl extends MasterServiceImpl<Composicao, Integer>
        implements ComposicaoService {

    @Autowired
    private ComposicaoRepository composicaoRepository;
    @Autowired
    private ComposicaoFioRepository composicaoFioRepository;
    @Autowired
    private FioService fioService;
    @Autowired
    private ModoLavarService modoLavarService;

    public ComposicaoServiceImpl(ComposicaoRepository composicaoRepository) {
        super(composicaoRepository);
    }

    @Override
    public Composicao save(Composicao entity) {
        if(entity.verificaTotalComposicao()) {
            entity = composicaoRepository.save(entity);

            for (ComposicaoFio cf : entity.getItensFios()) {
                cf.setFio(fioService.findById(cf.getFio().getId()));
                cf.setComposicao(entity);
                composicaoFioRepository.save(cf);
            }

            return entity;
        } else {
            throw new PorcentagemComposicaoException();
        }
    }

    @Override
    protected void updateData(Composicao updateEntity, Composicao entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setNumero(entity.getNumero());
        updateEntity.setItensFios(entity.getItensFios());
    }
}
