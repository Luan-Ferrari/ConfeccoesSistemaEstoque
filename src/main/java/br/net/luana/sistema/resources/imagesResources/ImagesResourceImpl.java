package br.net.luana.sistema.resources.imagesResources;

import br.net.luana.sistema.domain.images.ImageObject;
import br.net.luana.sistema.domain.images.URIImage;
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
    public ResponseEntity<Void> createImageObject(Integer entityId, MultipartFile file) {
        ImageObject imageObject = imagesService.createImageObject(entityId, file);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(imageObject.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> addImage(Integer entityId, MultipartFile file) {
        URIImage uriImage = imagesService.addImage(entityId, file);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(uriImage.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> delete(Integer entityId, String URIFile, Boolean imageReduzida) {
        if (imageReduzida) {
            imagesService.deleteImagemReduzida(entityId, URIFile);
        } else {
            imagesService.deleteImage(entityId, URIFile);
        }
        return ResponseEntity.noContent().build();
    }
}