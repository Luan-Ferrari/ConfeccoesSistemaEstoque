package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface MateriaPrimaResource<T extends MateriaPrima, ID extends Serializable> {

    @GetMapping
    public abstract ResponseEntity<List<T>> findAll();

    @GetMapping("/{entityId}")
    public abstract ResponseEntity<Optional<T>> findById(@PathVariable ID entityId);

    @PostMapping
    public abstract ResponseEntity<Void> insert(@RequestBody T entity);



}
