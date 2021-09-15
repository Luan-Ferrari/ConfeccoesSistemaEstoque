package br.net.luana.sistema.resources.imagesResources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

public interface ImagesResource {

    @PostMapping("cor/{corId}")
    ResponseEntity<Void> createImageObject(@PathVariable Integer corId,
                                           @RequestParam(name = "file") MultipartFile file,
                                           @RequestParam(value = "imagemPrincipal", defaultValue = "false") Boolean imagemPrincipal);

    @DeleteMapping("cor/{corId}")
    public abstract ResponseEntity<Void> delete(@PathVariable Integer corId,
                                                @RequestParam (value = "prefixo", defaultValue = "cor") String prefixo,
                                                @RequestParam (value = "uri") String URIFile);

    @PatchMapping("cor/{corId}/imagemPrincipal")
    public abstract ResponseEntity<Void> adicionaImagemPrincipal(@PathVariable Integer corId,
                                                               @RequestParam (value = "uri") String URIFile);

    @DeleteMapping("cor/{corId}/imagemPrincipal")
    public abstract ResponseEntity<Void> removeImagemPrincipal(@PathVariable Integer corId,
                                                               @RequestParam (value = "uri") String URIFile);
}
