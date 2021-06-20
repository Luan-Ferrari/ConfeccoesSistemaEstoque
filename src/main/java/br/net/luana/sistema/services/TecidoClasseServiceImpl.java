package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.TecidoClasse;
import br.net.luana.sistema.repositories.TecidoClasseRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TecidoClasseServiceImpl
        extends MasterServiceImpl<TecidoClasse, Integer>
        implements TecidoClasseService {

    public TecidoClasseServiceImpl(TecidoClasseRepository tecidoClasseRepository) {
        super(tecidoClasseRepository);
    }

    @Override
    protected void updateData(TecidoClasse updateEntity, TecidoClasse entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setNome(entity.getNome());
    }
}
