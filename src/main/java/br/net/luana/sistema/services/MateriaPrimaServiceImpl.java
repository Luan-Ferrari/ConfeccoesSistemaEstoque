package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.repositories.MateriaPrimaRepository;
import br.net.luana.sistema.services.exceptions.DataIntegrityException;
import br.net.luana.sistema.services.exceptions.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class MateriaPrimaServiceImpl<T extends MateriaPrima, ID extends Integer>
        implements MateriaPrimaService<T, ID>{

    private MateriaPrimaRepository materiaPrimaRepository;

    public MateriaPrimaServiceImpl(MateriaPrimaRepository materiaPrimaRepository) {
        this.materiaPrimaRepository = materiaPrimaRepository;
    }

    @Override
    public List<T> findAll() {
        return materiaPrimaRepository.findAll();
    }

    @Override
    public Page<T> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return materiaPrimaRepository.findAll(pageRequest);
    }

    @Override
    public T findById(ID entityId) {
        Optional<T> obj = materiaPrimaRepository.findById(entityId);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException(entityId)
        );
    }

    @Override
    public T save(T entity) {
        entity.setId(null);
        return (T) materiaPrimaRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID entityId) {
        T updateEntity = findById(entityId);
        updateData(updateEntity, entity);
        return (T) materiaPrimaRepository.save(updateEntity);

    }

    @Override
    public void deleteById(ID entityId) {
        findById(entityId);
        try {
            materiaPrimaRepository.deleteById(entityId);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(entityId);
        }
    }

        protected void updateData(T updateEntity, T entity) {
            updateEntity.setReferenciaNaFabrica(entity.getReferenciaNaFabrica());
            updateEntity.setObservacoes(entity.getObservacoes());
            updateEntity.setDesuso(entity.getDesuso());
            updateEntity.setUnidadeMedida(entity.getUnidadeMedida());
            updateEntity.setFornecedor(entity.getFornecedor());
    }

}
