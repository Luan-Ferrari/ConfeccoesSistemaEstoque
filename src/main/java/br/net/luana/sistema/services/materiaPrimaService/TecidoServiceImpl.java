package br.net.luana.sistema.services.materiaPrimaService;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import br.net.luana.sistema.repositories.materiaPrimaRepositories.TecidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TecidoServiceImpl extends MateriaPrimaServiceImpl<Tecido, Integer>
        implements TecidoService {

    private TecidoRepository tecidoRepository;

    public TecidoServiceImpl(TecidoRepository tecidoRepository) {
        super(tecidoRepository);
    }

    @Override
    protected void updateData(Tecido updateEntity, Tecido entity) {
        super.updateData(updateEntity, entity);
        updateEntity.setTipoTecido(entity.getTipoTecido());
        updateEntity.setClasse(entity.getClasse());
    }
}
