package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import br.net.luana.sistema.dto.TecidoDTO;
import br.net.luana.sistema.repositories.TecidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tecidoService")
@Transactional
public class TecidoServiceImpl extends MateriaPrimaServiceImpl<Tecido, TecidoDTO, Integer>
        implements TecidoService {

    @Autowired
    private TecidoDTO tecidoDTO;
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

    @Override
    public TecidoDTO toDto(Tecido entity) {
        tecidoDTO = super.toDto(entity);
        tecidoDTO.setTipoTecidoId(entity.getTipoTecido().getId());
        tecidoDTO.setTipoTecido(entity.getTipoTecido().getTipo());
        tecidoDTO.setTecidoClasseId(entity.getClasse().getId());
        tecidoDTO.setTecidoClasse(entity.getClasse().getNome());
        return tecidoDTO;
    }
}
