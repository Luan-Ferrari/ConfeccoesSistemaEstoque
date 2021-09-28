package br.net.luana.sistema.resources.imagesResources;

import br.net.luana.sistema.domain.images.ImageObject;
import br.net.luana.sistema.services.imagesServices.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/images")
public class ImagesResourceImpl implements ImagesResource{

    @Autowired
    private ImagesService imagesService;

    @Override
    public ResponseEntity<Void> createImageObject(Integer corId, MultipartFile file, Boolean imagemPrincipal) {
        ImageObject imageObject = imagesService.rotinaParaUploadDeImagem(corId, file, imagemPrincipal);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(imageObject.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> delete(Integer corId, String prefixo, String URIFile) {
        imagesService.rotinaParaExcluirImagem(corId, prefixo, URIFile);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> adicionaImagemPrincipal(Integer corId, String URIFile) {
        imagesService.salvarImagemPrincipalNoBD(corId, URIFile);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> removeImagemPrincipal(Integer corId, String URIFile) {
        imagesService.removerImagemPrincipalNoBD(corId, URIFile);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> uploadModoLavarImage(Integer modoLavarId, MultipartFile file) {
        URI uri = imagesService.uploadModoLavarImage(modoLavarId, file);
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> deleteModoLavarImage(Integer modoLavarId, String URIFile) {
        imagesService.deleteModoLavarImage(modoLavarId, URIFile);
        return ResponseEntity.noContent().build();
    }


}
