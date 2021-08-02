package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.Telefone;
import br.net.luana.sistema.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FornecedorServiceImpl
        extends MasterServiceImpl<Fornecedor, Integer>
        implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private TelefoneService telefoneService;

    public FornecedorServiceImpl(FornecedorRepository fornecedorRepository) {
        super(fornecedorRepository);
    }

    @Override
    public Fornecedor save(Fornecedor entity) {
        entity = fornecedorRepository.save(entity);
        for(Telefone telefone : entity.getTelefones()) {
            telefone.setFornecedor(entity);
            telefoneService.save(telefone);
        }
        return entity;
    }

    @Override
    public Fornecedor updateById(Fornecedor entity, Integer entityId) {
        Fornecedor updateEntity = findById(entityId);
        updateData(updateEntity, entity);
        for(Telefone telefone : entity.getTelefones()) {
            telefone.setFornecedor(updateEntity);
            telefoneService.save(telefone);
        }
        return fornecedorRepository.save(updateEntity);
    }

    @Override
    protected void updateData(Fornecedor updateEntity, Fornecedor entity) {
        updateEntity.setNome(entity.getNome());
        updateEntity.setCnpj(entity.getCnpj());
        updateEntity.setEmail(entity.getEmail());
        updateEntity.setDescricao(entity.getDescricao());
        updateEntity.setCidade(entity.getCidade());
    }
}
