package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.MasterDomain;
import br.net.luana.sistema.repositories.MasterRepository;
import br.net.luana.sistema.services.exceptions.DataIntegrityException;
import br.net.luana.sistema.services.exceptions.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public abstract class MasterServiceImpl<T extends MasterDomain, ID extends Integer>
        implements MasterService<T, ID>  {



    private MasterRepository masterRepository;

    public MasterServiceImpl(){}
    public MasterServiceImpl(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Override
    public List<T> findAll() {
        return masterRepository.findAll();
    }

    @Override
    public Page<T> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return masterRepository.findAll(pageRequest);
    }

    @Override
    public T findById(ID entityId) {
        Optional<T> obj = masterRepository.findById(entityId);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException(entityId)
        );
    }

    @Override
    public T save(T entity) {
        //entity.setId(null);
        return (T) masterRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID entityId) {
        T updateEntity = findById(entityId);
        updateData(updateEntity, entity);
        return (T) masterRepository.save(updateEntity);

    }

    @Override
    public void deleteById(ID entityId) {
        findById(entityId);
        try {
            masterRepository.deleteById(entityId);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(entityId);
        }
    }

    protected abstract void updateData(T updateEntity, T entity);
}
