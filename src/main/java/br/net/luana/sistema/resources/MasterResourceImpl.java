package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.MasterDomain;
import br.net.luana.sistema.dto.MasterDTOImpl;
import br.net.luana.sistema.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public abstract class MasterResourceImpl <T extends MasterDomain, D extends MasterDTOImpl, ID extends Integer>
        implements MasterResource<T, D, ID> {

    @Autowired
    private D dto;
    private MasterService masterService;

    public MasterResourceImpl(MasterService masterService) {
        this.masterService = masterService;
    }

    @Override
    public ResponseEntity<List<D>> findAll() {
        List<T> list = masterService.findAll();
        return ResponseEntity.ok().body(dto.makeListDTO(list));
    }

    @Override
    public ResponseEntity<Page<D>> findPage (Integer page, Integer linesPerPage, String direction, String orderBy ) {
        Page<T> list = masterService.findPage(page, linesPerPage, direction, orderBy);
        return ResponseEntity.ok().body(dto.makePageDTO(list));
    }

    @Override
    public ResponseEntity<D> findById(ID entityId) {
        T entity = (T) masterService.findById(entityId);
        return ResponseEntity.ok().body((D)dto.makeDTO(entity));
    }

    @Override
    public ResponseEntity<Void> insert(D dto) {
        T entity = (T)dto.makeEntityfromDTO(dto);
        entity = (T)masterService.save(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> update(T entity, ID entityId) {
        entity = (T)masterService.updateById(entity, entityId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> delete(ID entityId) {
        masterService.deleteById(entityId);
        return ResponseEntity.noContent().build();
    }
}
