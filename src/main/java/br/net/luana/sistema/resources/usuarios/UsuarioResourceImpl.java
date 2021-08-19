package br.net.luana.sistema.resources.usuarios;

import br.net.luana.sistema.domain.usuarios.Usuario;
import br.net.luana.sistema.dto.usuarios.UsuarioDTO;
import br.net.luana.sistema.resources.MasterResourceImpl;
import br.net.luana.sistema.services.usuarios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioResourceImpl extends MasterResourceImpl<Usuario, UsuarioDTO, Integer>
        implements UsuarioResource {

    @Autowired
    private UsuarioDTO usuarioDTO;
    @Autowired
    private UsuarioService usuarioService;

    public UsuarioResourceImpl(UsuarioService usuarioService) {
        super(usuarioService);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @Override
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> list = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarioDTO.makeListDTO(list));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @Override
    public ResponseEntity<Page<UsuarioDTO>> findPage (Integer page,
                                                      Integer linesPerPage,
                                                      String direction,
                                                      String orderBy ) {
        Page<Usuario> list = usuarioService.findPage(page, linesPerPage, direction, orderBy);
        return ResponseEntity.ok().body(usuarioDTO.makePageDTO(list));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @Override
    public ResponseEntity<UsuarioDTO> findById(Integer entityId) {
        Usuario entity = usuarioService.findById(entityId);
        return ResponseEntity.ok().body(usuarioDTO.makeDTO(entity));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @Override
    public ResponseEntity<Void> insert(UsuarioDTO dto) {
        Usuario entity = usuarioService.save(usuarioDTO.makeEntityfromDTO(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @Override
    public ResponseEntity<Void> update(Usuario entity, Integer entityId) {
        entity = usuarioService.updateById(entity, entityId);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @Override
    public ResponseEntity<Void> delete(Integer entityId) {
        usuarioService.deleteById(entityId);
        return ResponseEntity.noContent().build();
    }
}
