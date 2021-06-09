package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import br.net.luana.sistema.dto.TecidoDTO;
import br.net.luana.sistema.services.TecidoService;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tecido")
public class TecidoResourceImpl extends MateriaPrimaResourceImpl<Tecido, TecidoDTO, Integer>
        implements TecidoResource {

    private TecidoService tecidoService;


    public TecidoResourceImpl(TecidoService tecidoService) {
        super(tecidoService);
    }

////
////    public TecidoResourceImpl(TecidoService tecidoService) {
////        this.tecidoService = tecidoService;
////    }
//
//    @GetMapping
//    public ResponseEntity<List<TecidoDTO>> findAll() {
//        List<Tecido> list = tecidoService.findAll();
//        List<TecidoDTO> listDto = list.stream().map(obj -> new TecidoDTO(obj)).collect(Collectors.toList());
//        return ResponseEntity.ok().body(listDto);
//    }
//
////    @GetMapping("/page")
////    public ResponseEntity<Page<MateriaPrimaDTO>> findPage(
////            @RequestParam(value = "page", defaultValue = "0") Integer page,
////            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
////            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
////            @RequestParam(value = "orderBy", defaultValue = "referenciaNaFabrica") String orderBy) {
////        Page<Tecido> list = service.findPage(page, linesPerPage, direction, orderBy);
////        Page<MateriaPrimaDTO> listDto = list.map(obj -> new MateriaPrimaDTO(obj));
////        return ResponseEntity.ok().body(listDto);
////    }
//
////    @GetMapping("/{id}")
////    public ResponseEntity<Tecido> findById(@PathVariable Integer id) {
////        Tecido obj = service.findById(id);
////        return ResponseEntity.ok().body(obj);
////    }
//
//    @PostMapping
//    public ResponseEntity<Void> insert(@RequestBody Tecido obj) {
//        //if(materiaPrimaService.verificaDuplicidade())
//        obj = tecidoService.save(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
//
////    @PutMapping
////    public ResponseEntity<Void> update(@RequestBody Tecido obj, @PathVariable Integer id) {
////        obj.setId(id);
////        obj = service.update(obj);
////        return ResponseEntity.noContent().build();
////    }
////
////    @DeleteMapping("/{id}")
////    public ResponseEntity<Void> delete(@PathVariable Integer id) {
////        service.deleteById(id);
////        return ResponseEntity.noContent().build();
////    }
}
