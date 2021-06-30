package br.net.luana.sistema.services.composicaoServices;

import br.net.luana.sistema.domain.composicoes.Fio;
import br.net.luana.sistema.repositories.composicoes.FioRepository;
import br.net.luana.sistema.services.MasterServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FioServiceImpl extends MasterServiceImpl<Fio, Integer>
        implements FioService {

    public FioServiceImpl(FioRepository fioRepository) {
        super(fioRepository);
    }

    @Override
    protected void updateData(Fio updateEntity, Fio entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setNome(entity.getNome());
        updateEntity.setItens(entity.getItens());
    }
}
