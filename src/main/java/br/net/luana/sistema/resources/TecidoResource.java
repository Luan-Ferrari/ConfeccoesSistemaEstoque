package br.net.luana.sistema.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tecido")
public class TecidoResource {

    @GetMapping
    public String listar() {
        return "Teste OK!";
    }
}
