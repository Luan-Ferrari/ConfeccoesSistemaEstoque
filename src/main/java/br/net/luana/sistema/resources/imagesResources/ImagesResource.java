package br.net.luana.sistema.resources.imagesResources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface ImagesResource {

    @PostMapping("cor/{corId}/new")
    ResponseEntity<Void> createImageObject(@PathVariable Integer corId,
                                           @RequestParam(name = "file") MultipartFile file,
                                           @RequestParam(value = "imagemPrincipal", defaultValue = "false") Boolean imagemPrincipal);
//
//    @PostMapping("cor/{corId}/add")
//    ResponseEntity<Void> addImage(@PathVariable Integer corId,
//                                  @RequestParam(name = "file") MultipartFile file,
//                                  @RequestParam(value = "smallImage", defaultValue = "false") Boolean smallImage);
//
//    @DeleteMapping("cor/{corId}")
//    public abstract ResponseEntity<Void> delete(@PathVariable Integer corId,
//                                                @RequestParam (value = "uri") String URIFile,
//                                                @RequestParam (value = "smallImage") Boolean ImageReduzida);
}
