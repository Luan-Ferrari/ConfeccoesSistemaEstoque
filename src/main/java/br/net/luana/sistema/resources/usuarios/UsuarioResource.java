package br.net.luana.sistema.resources.usuarios;

import br.net.luana.sistema.domain.usuarios.Usuario;
import br.net.luana.sistema.dto.usuarios.UsuarioDTO;
import br.net.luana.sistema.resources.MasterResource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface UsuarioResource extends MasterResource<Usuario, UsuarioDTO, Integer> {

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public abstract ResponseEntity<List<UsuarioDTO>> findAll();

    @GetMapping("/page")
    public abstract ResponseEntity<Page<UsuarioDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "referenciaNaFabrica") String orderBy);

    @GetMapping("/{entityId}")
    public abstract ResponseEntity<UsuarioDTO> findById(@PathVariable Integer entityId);

    @PostMapping
    public abstract ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO dto);

    @PutMapping("/{entityId}")
    public abstract ResponseEntity<Void> update(@RequestBody Usuario entity, @PathVariable Integer entityId);

    @DeleteMapping("/{entityId}")
    public abstract ResponseEntity<Void> delete(@PathVariable Integer entityId);
}
