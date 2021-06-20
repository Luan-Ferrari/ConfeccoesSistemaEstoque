package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.CorEntradas;
import br.net.luana.sistema.repositories.CorEntradasRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorEntradasServiceImpl extends MasterServiceImpl<CorEntradas, Integer>
        implements CorEntradasService {

    public CorEntradasServiceImpl(CorEntradasRepository corEntradasRepository) {
        super(corEntradasRepository);
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
