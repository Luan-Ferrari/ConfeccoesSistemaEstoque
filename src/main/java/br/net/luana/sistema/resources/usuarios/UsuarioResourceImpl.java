package br.net.luana.sistema.resources.usuarios;

import br.net.luana.sistema.domain.usuarios.Usuario;
import br.net.luana.sistema.dto.usuarios.UsuarioDTO;
import br.net.luana.sistema.resources.MasterResourceImpl;
import br.net.luana.sistema.services.usuarios.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioResourceImpl extends MasterResourceImpl<Usuario, UsuarioDTO, Integer>
        implements UsuarioResource {


    public UsuarioResourceImpl(UsuarioService usuarioService) {
        super(usuarioService);
    }
}
