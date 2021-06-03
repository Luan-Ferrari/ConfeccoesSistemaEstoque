package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface MateriaPrimaService<T extends MateriaPrima, ID extends Serializable> {

    public abstract T save (T entity);
    public abstract List<T> findAll();

    public abstract Optional<T> findById(ID entityId);
    public abstract T update(T entity);
    public abstract T updateById(T entity, ID entityId);
    public abstract void delete(T entity);
    public abstract void deleteById(ID entityId);




//    public Boolean verificaDuplicidade(MateriaPrima obj) {
//        Optional<MateriaPrima> searchObj = repository.findByReferenciaNaFabricaAndFornecedor(
//                obj.getReferenciaNaFabrica(), obj.getFornecedor());
//        if(searchObj.isPresent()) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
