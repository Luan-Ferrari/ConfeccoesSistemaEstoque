package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.MasterDomain;
import br.net.luana.sistema.dto.MasterDTO;
import br.net.luana.sistema.dto.MasterDTOImpl;
import br.net.luana.sistema.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.Access;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public abstract class MasterResourceImpl <T extends MasterDomain, D extends MasterDTOImpl, ID extends Integer>
        implements MasterResource<T, D, ID> {

    @Autowired
    private D DTO;
    private MasterService masterService;

    public MasterResourceImpl(MasterService masterService) {
        this.masterService = masterService;
    }

    @Override
    public ResponseEntity<List<D>> findAll() {
        List<T> list = masterService.findAll();
        List<D> listDto = new ArrayList<>();/*list.stream().map(obj -> (D) DTO.makeDTO(obj)).collect(Collectors.toList())*/
//        for (T entity : list) {
//            new MasterDTOImpl();
//            MasterDTOImpl objDto = DTO.makeDTO(entity);
//            listDto.add((D)objDto);
//        }
//        for(D entity : listDto) {
//            System.out.println(entity.getId());
//        }
        listDto = DTO.makeListDTO(list);

        return ResponseEntity.ok().body(listDto);
    }

    @Override
    public ResponseEntity<Page<T>> findPage (Integer page, Integer linesPerPage, String direction, String orderBy ) {
        Page<T> list = masterService.findPage(page, linesPerPage, direction, orderBy);
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<T> findById(ID entityId) {
        T entity = (T) masterService.findById(entityId);
        return ResponseEntity.ok().body(entity);
    }

    @Override
    public ResponseEntity<Void> insert(T entity) {
        entity = (T)masterService.save(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(5).toUri(); /*< SUBISTITUIR 5 POR entity.getId()*/
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
