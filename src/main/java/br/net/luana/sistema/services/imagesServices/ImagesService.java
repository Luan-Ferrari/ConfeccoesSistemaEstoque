package br.net.luana.sistema.services.imagesServices;

import br.net.luana.sistema.domain.images.ImageObject;
import br.net.luana.sistema.domain.images.URIImage;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

public interface ImagesService {

    public ImageObject setOrCreateImageObject(Integer corId, MultipartFile file);

    public ImageObject createImageObject(Integer corId, MultipartFile multipartFile);

    public URIImage addImage(Integer imageObjectId, MultipartFile file);

    public URI uploadImages(MultipartFile multipartFile);

    public void deleteImage(Integer corId, String URIFile);

    public void deleteImagemReduzida(Integer corId, String URFile);
}
