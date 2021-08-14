package br.net.luana.sistema.repositories.usuarios;

import br.net.luana.sistema.domain.usuarios.Usuario;
import br.net.luana.sistema.repositories.MasterRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MasterRepository<Usuario, Integer> {

    Usuario findByNome(String nome);
}
