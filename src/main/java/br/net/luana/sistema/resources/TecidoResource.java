package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import br.net.luana.sistema.dto.TecidoDTO;
import br.net.luana.sistema.services.TecidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tecido")
public class TecidoResource {

    @Autowired
    private TecidoServiceImpl service;

    @GetMapping
    public ResponseEntity<List<TecidoDTO>> findAll() {
        List<Tecido> list = service.findAll();
        List<TecidoDTO> listDto = list.stream().map(obj -> new TecidoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

//    @GetMapping("/page")
//    public ResponseEntity<Page<MateriaPrimaDTO>> findPage(
//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
//            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
//            @RequestParam(value = "orderBy", defaultValue = "referenciaNaFabrica") String orderBy) {
//        Page<Tecido> list = service.findPage(page, linesPerPage, direction, orderBy);
//        Page<MateriaPrimaDTO> listDto = list.map(obj -> new MateriaPrimaDTO(obj));
//        return ResponseEntity.ok().body(listDto);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Tecido> findById(@PathVariable Integer id) {
//        Tecido obj = service.findById(id);
//        return ResponseEntity.ok().body(obj);
//    }

//    @PostMapping
//    public ResponseEntity<Void> insert(@RequestBody Tecido obj) {
//        //if(materiaPrimaService.verificaDuplicidade())
//        obj = service.insert(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Tecido obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
