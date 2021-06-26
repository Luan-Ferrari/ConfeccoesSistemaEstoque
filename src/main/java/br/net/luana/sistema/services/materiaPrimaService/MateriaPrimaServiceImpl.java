package br.net.luana.sistema.services.materiaPrimaService;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.repositories.materiaPrimaRepositories.MateriaPrimaRepository;
import br.net.luana.sistema.services.MasterServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public abstract class MateriaPrimaServiceImpl<T extends MateriaPrima, ID extends Integer>
        extends MasterServiceImpl<T, ID>
        implements MateriaPrimaService<T, ID>{

    private MateriaPrimaRepository materiaPrimaRepository;

    public MateriaPrimaServiceImpl(MateriaPrimaRepository materiaPrimaRepository) {
        super(materiaPrimaRepository);
    }

    @Override
    protected void updateData(T updateEntity, T entity) {
        updateEntity.setReferenciaNaFabrica(entity.getReferenciaNaFabrica());
        updateEntity.setObservacoes(entity.getObservacoes());
        updateEntity.setDesuso(entity.getDesuso());
        updateEntity.setUnidadeMedida(entity.getUnidadeMedida());
        updateEntity.setFornecedor(entity.getFornecedor());
    }

}
