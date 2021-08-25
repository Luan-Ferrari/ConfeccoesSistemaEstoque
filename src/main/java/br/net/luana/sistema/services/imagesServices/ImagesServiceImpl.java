package br.net.luana.sistema.services.imagesServices;

import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.domain.images.ImageObject;
import br.net.luana.sistema.domain.images.URIImage;
import br.net.luana.sistema.repositories.imagesRepositories.ImageObjectRepository;
import br.net.luana.sistema.repositories.imagesRepositories.URIImageRepository;
import br.net.luana.sistema.services.corServices.CorService;
import br.net.luana.sistema.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@Service
public class ImagesServiceImpl implements ImagesService{

    @Autowired
    private ImageObjectRepository imageObjectRepository;
    @Autowired
    private URIImageRepository uriImageRepository;
    @Autowired
    private CorService<Cor, Integer> corService;
    @Autowired
    private S3Service s3Service;

    public ImageObject createImageObject(Integer corId, MultipartFile file) {
        ImageObject imageObject = new ImageObject();
        imageObject.setCor(corService.findById(corId));
        imageObject.setURIImageReduzida(uploadImages(file).toString());
        return imageObjectRepository.save(imageObject);
    }

    public URIImage addImage(Integer imageObjectId, MultipartFile file) {
        URIImage uriImage = new URIImage();
        uriImage.setImageObject(imageObjectRepository.findById(imageObjectId).get());
        uriImage.setURIImage(uploadImages(file).toString());
        return uriImageRepository.save(uriImage);
    }

    public void deleteImage(Integer corId, String URIFile) {
        URIImage image = uriImageRepository.findByURIImage(URIFile);
        if (image != null && image.getImageObject().getCor().getId().equals(corId)) {
            s3Service.deleteFile(URIFile);
            uriImageRepository.deleteById(image.getId());
        } else {
            throw new ObjectNotFoundException(URIFile);
        }
    }

    public void deleteImagemReduzida(Integer corId, String URFile) {
        ImageObject imageObject = imageObjectRepository.findByURIImageReduzida(URFile);
        if(imageObject != null && imageObject.getCor().getId().equals(corId)) {
            s3Service.deleteFile(URFile);
            imageObject.setURIImageReduzida(null);
            imageObjectRepository.save(imageObject);
        } else {
            throw new ObjectNotFoundException(URFile);
        }
    }

    public URI uploadImages(MultipartFile multipartFile) {
        return s3Service.uploadFile(multipartFile);
    }
}
