package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.materiasprimas.Colchete;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import br.net.luana.sistema.dto.MateriaPrimaDTO;
import br.net.luana.sistema.dto.TecidoDTO;
import br.net.luana.sistema.services.ColcheteService;
import br.net.luana.sistema.services.ColcheteServiceImpl;
import br.net.luana.sistema.services.TecidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/colchete")
public class ColcheteResourceImpl extends MateriaPrimaResourceImpl<Colchete, Integer>
        implements ColcheteResource {

    private ColcheteService colcheteService;

    @Autowired
    public ColcheteResourceImpl(ColcheteService colcheteService) {
        super(colcheteService);
    }

//    @GetMapping
//    public ResponseEntity<List<MateriaPrimaDTO>> findAll() {
//        List<Colchete> list = colcheteService.findAll();
//        List<MateriaPrimaDTO> listDto = list.stream().map(obj -> new MateriaPrimaDTO(obj)).collect(Collectors.toList());
//        return ResponseEntity.ok().body(listDto);
//    }
//
//    @PostMapping
//    public ResponseEntity<Void> insert(@RequestBody Colchete obj) {
//        //if(materiaPrimaService.verificaDuplicidade())
//        obj = colcheteService.save(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
}
