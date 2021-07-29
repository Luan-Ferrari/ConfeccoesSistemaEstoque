package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.TipoFornecedor;
import br.net.luana.sistema.repositories.TipoFornecedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoFornecedorServiceImpl
        extends MasterServiceImpl<TipoFornecedor, Integer>
        implements TipoFornecedorService {

    public TipoFornecedorServiceImpl(TipoFornecedorRepository tipoFornecedorRepository) {
        super(tipoFornecedorRepository);
    }

    @Override
    protected void updateData(TipoFornecedor updateEntity, TipoFornecedor entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setTipoFornecedor(entity.getTipoFornecedor());
    }
}
