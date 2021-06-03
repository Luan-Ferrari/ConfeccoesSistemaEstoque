package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.repositories.MateriaPrimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class MateriaPrimaServiceImpl<T extends MateriaPrima, ID extends Serializable>
        implements MateriaPrimaService<T, ID>{

    private MateriaPrimaRepository<T, ID> materiaPrimaRepository;

    @Autowired
    public MateriaPrimaServiceImpl(MateriaPrimaRepository<T, ID> materiaPrimaRepository) {
        this.materiaPrimaRepository = materiaPrimaRepository;
    }

    @Override
    public T save(T entity) {
        return (T) materiaPrimaRepository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return materiaPrimaRepository.findAll();
    }

    @Override
    public Optional<T> findById(ID entityId) {
        return materiaPrimaRepository.findById(entityId);
    }

    @Override
    public T update(T entity) {
        return (T) materiaPrimaRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID entityId) {
        Optional<T> optional = materiaPrimaRepository.findById(entityId);
        if(optional.isPresent()) {
            return (T) materiaPrimaRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(T entity) {
        materiaPrimaRepository.delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        materiaPrimaRepository.deleteById(entityId);
    }
}
