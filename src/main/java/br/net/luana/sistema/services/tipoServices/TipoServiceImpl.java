package br.net.luana.sistema.services.tipoServices;

import br.net.luana.sistema.domain.tipos.Tipo;
import br.net.luana.sistema.repositories.tipoRepositories.TipoRepository;
import br.net.luana.sistema.services.MasterServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public abstract class TipoServiceImpl <T extends Tipo, ID extends Integer>
        extends MasterServiceImpl<T, ID>
        implements TipoService<T, ID> {


    public TipoServiceImpl(TipoRepository tipoRepository) {
        super(tipoRepository);
    }

    @Override
    protected void updateData(T updateEntity, T entity) {
        updateEntity.setTipo(entity.getTipo());
    }
}
