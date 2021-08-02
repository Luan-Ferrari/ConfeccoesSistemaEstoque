package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.Telefone;
import br.net.luana.sistema.repositories.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TelefoneServiceImpl extends MasterServiceImpl<Telefone, Integer>
        implements TelefoneService {

    @Autowired
    TelefoneRepository telefoneRepository;
    public TelefoneServiceImpl(TelefoneRepository telefoneRepository) {
        super(telefoneRepository);
    }

    @Override
    public Telefone save(Telefone entity) {
        if (entity.getId() == null) {
            telefoneRepository.save(entity);
        } else {
            updateById(entity, entity.getId());
        }
        return entity;
    }

    @Override
    protected void updateData(Telefone updateEntity, Telefone entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setDdd(entity.getDdd());
        updateEntity.setTelefone(entity.getTelefone());
        updateEntity.setRamal(entity.getRamal());
    }
}
