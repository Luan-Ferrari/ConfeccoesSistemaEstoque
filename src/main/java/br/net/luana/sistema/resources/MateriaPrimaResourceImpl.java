package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.resources.MateriaPrimaResource;
import br.net.luana.sistema.services.MateriaPrimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.Optional;

public class MateriaPrimaResourceImpl<T extends MateriaPrima, ID extends Serializable>
        implements MateriaPrimaResource<T, ID> {

    private MateriaPrimaService materiaPrimaService;

    public MateriaPrimaResourceImpl(MateriaPrimaService materiaPrimaService) {
        this.materiaPrimaService = materiaPrimaService;
    }

    @Override
    public ResponseEntity<List<T>> findAll() {
        List<T> list = materiaPrimaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<Optional<T>> findById(ID entityId) {
        Optional<T> entity = materiaPrimaService.findById(entityId);
        return ResponseEntity.ok().body(entity);
    }

    @Override
    public ResponseEntity<Void> insert(T entity) {
        entity = (T)materiaPrimaService.save(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
