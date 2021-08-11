package br.net.luana.sistema.services.usuarios;

import br.net.luana.sistema.domain.usuarios.Usuario;
import br.net.luana.sistema.repositories.usuarios.UsuarioRepository;
import br.net.luana.sistema.services.MasterServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl extends MasterServiceImpl<Usuario, Integer>
        implements UsuarioService {

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }

    @Override
    protected void updateData(Usuario updateEntity, Usuario entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setNome(entity.getNome());
    }
}
