package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.materiasprimas.Colchete;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import br.net.luana.sistema.dto.MateriaPrimaDTO;
import br.net.luana.sistema.dto.TecidoDTO;
import br.net.luana.sistema.services.ColcheteServiceImpl;
import br.net.luana.sistema.services.TecidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/colchete")
public class ColcheteResource {

    @Autowired
    private ColcheteServiceImpl service;

    @GetMapping
    public ResponseEntity<List<MateriaPrimaDTO>> findAll() {
        List<Colchete> list = service.findAll();
        List<MateriaPrimaDTO> listDto = list.stream().map(obj -> new MateriaPrimaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
