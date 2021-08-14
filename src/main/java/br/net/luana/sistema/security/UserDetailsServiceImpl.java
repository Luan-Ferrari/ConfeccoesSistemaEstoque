package br.net.luana.sistema.security;

import br.net.luana.sistema.domain.usuarios.Usuario;
import br.net.luana.sistema.repositories.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNome(nome);
        if(usuario == null) {
            throw new UsernameNotFoundException(nome);
        }
        return new UserSS(usuario.getId(), usuario.getNome(), usuario.getSenha(), usuario.getPerfil());
    }
}
