package br.net.luana.sistema.services.corServices;

import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.repositories.corRepositories.CorRepository;
import br.net.luana.sistema.services.MasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorServiceImpl<T extends Cor, ID extends Integer>
        extends MasterServiceImpl<T, ID>
        implements CorService<T, ID> {

    @Autowired
    CorRepository corRepository;

    public CorServiceImpl(CorRepository corRepository) {
        super(corRepository);
    }

    public void acrescentarQuantidadeCorEstoque(Cor cor, Double quantidade) {
        cor.acrescentarQuantidade(quantidade);
        corRepository.save(cor);
    }

    public void diminuirQuantidadeCorEstoque(Cor cor, Double quantidade) {
        cor.diminuirQuantidade(quantidade);
        corRepository.save(cor);
    }

    @Override
    protected void updateData(T updateEntity, T entity) {
        updateEntity.setReferenciaNaFabrica(entity.getReferenciaNaFabrica());
        updateEntity.setNome(entity.getNome());
        updateEntity.setObservacoes(entity.getObservacoes());
        updateEntity.setQuantidadeEstoque(entity.getQuantidadeEstoque());
    }
}
