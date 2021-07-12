package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.CorEntradas;
import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.repositories.CorEntradasRepository;
import br.net.luana.sistema.repositories.corRepositories.CorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorEntradasServiceImpl extends MasterServiceImpl<CorEntradas, Integer>
        implements CorEntradasService {

    @Autowired
    private CorEntradasRepository corEntradasRepository;
    @Autowired
    private CorRepository corRepository;

    public CorEntradasServiceImpl(CorEntradasRepository corEntradasRepository) {
        super(corEntradasRepository);
    }

    @Override
    public CorEntradas save(CorEntradas entity) {
        Cor cor = (Cor) corRepository.findById(entity.getCor().getId()).get();
        cor.acrescentarQuantidade(entity.getQuantidade());
        corRepository.save(cor);
        return corEntradasRepository.save(entity);
    }

    @Override
    protected void updateData(CorEntradas updateEntity, CorEntradas entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setDataEntrada(entity.getDataEntrada());
        updateEntity.setDataFim(entity.getDataFim());
        updateEntity.setPreco(entity.getPreco());
        updateEntity.setQuantidade(entity.getQuantidade());
        updateEntity.setCor(entity.getCor());
    }
}
