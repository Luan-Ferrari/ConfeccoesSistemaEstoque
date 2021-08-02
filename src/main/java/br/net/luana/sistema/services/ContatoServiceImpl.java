package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.Contato;
import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.Telefone;
import br.net.luana.sistema.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContatoServiceImpl extends MasterServiceImpl<Contato, Integer>
        implements ContatoService {

    @Autowired
    TelefoneService telefoneService;
    @Autowired
    ContatoRepository contatoRepository;
    @Autowired
    FornecedorService fornecedorService;

    public ContatoServiceImpl(ContatoRepository contatoRepository) {
        super(contatoRepository);
    }

    @Override
    public Contato save(Contato entity) {
        entity = contatoRepository.save(entity);
        for(Telefone telefone : entity.getTelefones()) {
            telefone.setContato(entity);
            telefoneService.save(telefone);
        }
        for(Fornecedor fornecedor : entity.getFornecedores()) {
            fornecedor = fornecedorService.findById(fornecedor.getId());
            fornecedor.getContatos().add(entity);
        }
        return entity;
    }

    @Override
    public Contato updateById(Contato entity, Integer entityId) {
        Contato updateEntity = findById(entityId);
        updateData(updateEntity, entity);
        for(Telefone telefone : entity.getTelefones()) {
            telefone.setContato(updateEntity);
            telefoneService.save(telefone);
        }
        return contatoRepository.save(updateEntity);
    }

    @Override
    protected void updateData(Contato updateEntity, Contato entity) {
        updateEntity.setNome(entity.getNome());
        updateEntity.setFuncao(entity.getFuncao());
        updateEntity.setEmail(entity.getEmail());
    }
}
