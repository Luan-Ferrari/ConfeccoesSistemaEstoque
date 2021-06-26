package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.CaixaBojo;
import br.net.luana.sistema.domain.CorEntradas;
import br.net.luana.sistema.repositories.CaixaBojoRepository;
import br.net.luana.sistema.repositories.CorEntradasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CaixaBojoServiceImpl extends MasterServiceImpl<CaixaBojo, Integer>
        implements CaixaBojoService {

    public CaixaBojoServiceImpl(CaixaBojoRepository caixaBojoRepository) {
        super(caixaBojoRepository);
    }

    @Override
    protected void updateData(CaixaBojo updateEntity, CaixaBojo entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setNomeCaixa(entity.getNomeCaixa());
        updateEntity.setCoresArmazenadas(entity.getCoresArmazenadas());
    }
}
