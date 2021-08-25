package br.net.luana.sistema.resources.imagesResources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface ImagesResource {

    @PostMapping("/{entityId}/new")
    ResponseEntity<Void> createImageObject(@PathVariable Integer entityId,
                                           @RequestParam(name = "file") MultipartFile file);

    @PostMapping("/{entityId}/add")
    ResponseEntity<Void> addImage(@PathVariable Integer entityId,
                                  @RequestParam(name = "file") MultipartFile file);

    @DeleteMapping("/{entityId}")
    public abstract ResponseEntity<Void> delete(@PathVariable Integer entityId,
                                                @RequestParam (value = "uri") String URIFile,
                                                @RequestParam (value = "reduzida") Boolean ImageReduzida);
}
