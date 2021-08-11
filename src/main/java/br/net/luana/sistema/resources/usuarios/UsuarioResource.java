package br.net.luana.sistema.resources.usuarios;

import br.net.luana.sistema.domain.usuarios.Usuario;
import br.net.luana.sistema.dto.usuarios.UsuarioDTO;
import br.net.luana.sistema.resources.MasterResource;

public interface UsuarioResource extends MasterResource<Usuario, UsuarioDTO, Integer> {
}
