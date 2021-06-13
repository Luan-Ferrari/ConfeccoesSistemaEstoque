package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.dto.MasterDTOImpl;
import br.net.luana.sistema.services.materiaPrimaService.MateriaPrimaService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class MateriaPrimaResourceImpl<T extends MateriaPrima, D extends MasterDTOImpl, ID extends Integer>
        extends MasterResourceImpl<T, D, ID>
        implements MateriaPrimaResource<T, D, ID> {

    private MateriaPrimaService materiaPrimaService;

    public MateriaPrimaResourceImpl(MateriaPrimaService materiaPrimaService) {
        super(materiaPrimaService);
    }
//
//    @Override
//    public ResponseEntity<List<D>> findAll() {
//        List<T> list = materiaPrimaService.findAll();
//        List<D> listDto = new ArrayList<>()/*list.stream().map(obj -> (D) DTO.makeDTO(obj)).collect(Collectors.toList())*/;
//        for(T entity : list) {
//            System.out.println("Resource " + entity.getId());
//            D teste = (D)DTO.makeDTO(entity);
//            System.out.println("Apos retorno makeDTO " + teste.getId());
//            listDto.add(teste);
//        }
//        for(D entity : listDto) {
//            System.out.println(entity.getId());
//        }
//        return ResponseEntity.ok().body(listDto);
//    }
//
//    @Override
//    public ResponseEntity<Page<T>> findPage (Integer page, Integer linesPerPage, String direction, String orderBy ) {
//        Page<T> list = materiaPrimaService.findPage(page, linesPerPage, direction, orderBy);
//        return ResponseEntity.ok().body(list);
//    }
//
//    @Override
//    public ResponseEntity<T> findById(ID entityId) {
//        T entity = (T) materiaPrimaService.findById(entityId);
//        return ResponseEntity.ok().body(entity);
//    }
//
//    @Override
//    public ResponseEntity<Void> insert(T entity) {
//        entity = (T)materiaPrimaService.save(entity);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(entity.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
//
//    @Override
//    public ResponseEntity<Void> update(T entity, ID entityId) {
//        entity = (T)materiaPrimaService.updateById(entity, entityId);
//        return ResponseEntity.noContent().build();
//    }
//
//    @Override
//    public ResponseEntity<Void> delete(ID entityId) {
//        materiaPrimaService.deleteById(entityId);
//        return ResponseEntity.noContent().build();
//    }
//

}
