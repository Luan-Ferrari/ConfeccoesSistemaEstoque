package br.net.luana.sistema.services.imagesServices;

import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.domain.images.ImageObject;
import br.net.luana.sistema.domain.images.ProductImages;
import br.net.luana.sistema.repositories.imagesRepositories.ImageObjectRepository;
import br.net.luana.sistema.repositories.imagesRepositories.ProductImagesRepository;
import br.net.luana.sistema.services.corServices.CorService;
import br.net.luana.sistema.services.exceptions.FileException;
import br.net.luana.sistema.services.exceptions.ObjectNotFoundException;
import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.webp.WebpWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityExistsException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ImagesServiceImpl implements ImagesService{

    private final int quantidadeMaximaImagensPrincipais = 2;

    @Autowired
    private ImageObjectRepository imageObjectRepository;
    @Autowired
    private ProductImagesRepository productImagesRepository;
    @Autowired
    private CorService<Cor, Integer> corService;
    @Autowired
    private S3Service s3Service;
    @Autowired
    private ImageResolver imageResolver;


    //ok
    @Override
    public ImageObject findById(Integer entityId) {
        Optional<ImageObject> obj = imageObjectRepository.findById(entityId);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }
    }

    public ImageObject rotinaParaUploadDeImagem(Integer corId, MultipartFile multipartFile,
                                                Boolean imagemPrincipal) {
        ImageObject imageObject = defineImageObject(corId);
        String imageName = imageResolver.createImageName(corId);
        List<String> fileNames = imageResolver.getListFileNames(imageName);

        for(int i = 0; i < fileNames.size(); i++ ) {
            File fileWebp = convertToWebp(multipartFile, imageResolver.getLargura(i),
                    imageResolver.getAltura(i));
            uploadImage(fileWebp, fileNames.get(i));

        }
        rotinaParaPersistirNoBD(imageObject, imageName, imagemPrincipal);

        return imageObject;
    }

    public void rotinaParaPersistirNoBD(ImageObject imageObject, String imageName, Boolean imagemPrincipal) {

        ProductImages productImages = new ProductImages();
        productImages.setImageObject(imageObject);
        productImages.setImageName(imageName);
        productImages = productImagesRepository.save(productImages);

        if(imagemPrincipal) {
            if(!listaImagensPrincipaisCompleta(imageObject)) {
                imageObject.getImagensPrincipais().add(imageName);
                imageObject = imageObjectRepository.save(imageObject);
            } else {
                throw new FileException("TEM MUITA IMAGEM PRINCIPAL");
            }
        }
    }

    //ok
    public ImageObject defineImageObject(Integer corId) {
        try {
            ImageObject imageObject = findById(corId);
            if (imageObject == null) {
                Cor cor = corService.findById(corId);
                return createImageObject(cor);
            } else {
                return imageObject;
            }
        } catch (EntityExistsException e) {
            throw new EntityExistsException();
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException(corId);
        }
    }

    //ok
    public ImageObject createImageObject(Cor cor) {
        ImageObject imageObject = new ImageObject();
        imageObject.setCor(cor);
        return imageObjectRepository.save(imageObject);
    }



    // recorte da funcao defineImageObject
//        if (imagemPrincipal) {
//        if(!listaImagensPrincipaisCompleta(imageObject.get())) {
//            imageObject.get().getImagensPrincipais().add(uploadImageMaster(corId, file));
//        } else {
//            throw new EntityExistsException();
//        }
//    }
//
//                imageObject.get().setSmallImageName(uploadImages(file).toString());
//                return imageObjectRepository.save(imageObject.get());
//} else {
//        return createImageObject(corId, file);
//        }
//


//    public ProductImages addImage(Integer imageObjectId, MultipartFile file) {
//        ProductImages uriImage = new ProductImages();
//        uriImage.setImageObject(imageObjectRepository.findById(imageObjectId).get());
//        uriImage.setURIImage(uploadImages(file).toString());
//        return productImagesRepository.save(uriImage);
//    }

//    public void deleteImage(Integer corId, String URIFile) {
//        ProductImages image = productImagesRepository.findByURIImage(URIFile);
//        if (image != null && image.getImageObject().getCor().getId().equals(corId)) {
//            s3Service.deleteFile(URIFile);
//            productImagesRepository.deleteById(image.getId());
//        } else {
//            throw new ObjectNotFoundException(URIFile);
//        }
//    }
//
//    public void deleteImagemReduzida(Integer corId, String URFile) {
//        ImageObject imageObject = imageObjectRepository.findByURIImageReduzida(URFile);
//        if(imageObject != null && imageObject.getCor().getId().equals(corId)) {
//            s3Service.deleteFile(URFile);
//            //imageObject.setURIImageReduzida(null);
//            imageObjectRepository.save(imageObject);
//        } else {
//            throw new ObjectNotFoundException(URFile);
//        }
//    }

    //ok
    public boolean listaImagensPrincipaisCompleta(ImageObject imageObject) {
        if (imageObject.getImagensPrincipais().size() < quantidadeMaximaImagensPrincipais) {
            return false;
        } else {
            return true;
        }
    }

    //ok
    public File convertToWebp(MultipartFile multipartFile, Integer largura, Integer altura) {
        try {
            File file = new File(".temp/imagesService/webpTemporario.webp");
            ImmutableImage image = ImmutableImage.loader().fromStream(multipartFile.getInputStream());
            WebpWriter webpWriter = new WebpWriter(); //Serve para controlar a qualidade da imagem webp de saída
            image.fit(largura, altura, Color.CYAN).output(WebpWriter.DEFAULT, ".temp/imagesService/webpTemporario.webp");

            return file;

        } catch (IOException e) {
            throw new FileException("Deu um erro na conversão para WEBP");
        }
    }

    public URI uploadImage(File file, String fileName) {
        return s3Service.uploadFile(file, fileName);
    }
}
