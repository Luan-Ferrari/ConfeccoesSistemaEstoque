package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.services.MateriaPrimaService;

import org.hibernate.type.EntityType;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.Optional;

public class MateriaPrimaResourceImpl<T extends MateriaPrima, ID extends Integer>
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
    public ResponseEntity<Page<T>> findPage (Integer page, Integer linesPerPage, String direction, String orderBy ) {
        Page<T> list = materiaPrimaService.findPage(page, linesPerPage, direction, orderBy);
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<T> findById(ID entityId) {
        T entity = (T) materiaPrimaService.findById(entityId);
        return ResponseEntity.ok().body(entity);
    }

    @Override
    public ResponseEntity<Void> insert(T entity) {
        entity = (T)materiaPrimaService.save(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> update(T entity, ID entityId) {
        entity = (T)materiaPrimaService.updateById(entity, entityId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> delete(ID entityId) {
        materiaPrimaService.deleteById(entityId);
        return ResponseEntity.noContent().build();
    }


}
