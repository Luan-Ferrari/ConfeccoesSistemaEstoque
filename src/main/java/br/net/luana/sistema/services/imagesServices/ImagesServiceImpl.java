package br.net.luana.sistema.services.imagesServices;

import br.net.luana.sistema.domain.composicoes.ModoLavar;
import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.domain.images.ImageObject;
import br.net.luana.sistema.domain.images.ProductImages;
import br.net.luana.sistema.repositories.imagesRepositories.ImageObjectRepository;
import br.net.luana.sistema.repositories.imagesRepositories.ProductImagesRepository;
import br.net.luana.sistema.services.composicaoServices.ModoLavarService;
import br.net.luana.sistema.services.corServices.CorService;
import br.net.luana.sistema.services.exceptions.FileException;
import br.net.luana.sistema.services.exceptions.ObjectNotFoundException;
import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.webp.WebpWriter;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private ModoLavarService modoLavarService;


    @Override
    public ImageObject findById(Integer entityId) {
        Optional<ImageObject> obj = imageObjectRepository.findById(entityId);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new ObjectNotFoundException(entityId);
        }
    }

    public ImageObject rotinaParaUploadDeImagem(Integer corId, MultipartFile multipartFile,
                                                Boolean imagemPrincipal) {
        if(extensaoImagemPermitida(multipartFile)) {
            ImageObject imageObject = defineImageObject(corId);
            String imageName = imageResolver.createImageName(corId);
            List<String> fileNames = imageResolver.getListFileNames(imageName);

            for (int i = 0; i < fileNames.size(); i++) {
                File fileWebp = convertToWebp(multipartFile, imageResolver.getLargura(i),
                        imageResolver.getAltura(i));
                uploadImage(fileWebp, fileNames.get(i));

            }
            rotinaParaPersistirNoBD(imageObject, imageName, imagemPrincipal);

            return imageObject;
        } else
            return null;
    }

    public void rotinaParaPersistirNoBD(ImageObject imageObject, String imageName, Boolean imagemPrincipal) {

        ProductImages productImages = new ProductImages();
        productImages.setImageObject(imageObject);
        productImages.setImageName(imageName);
        productImages = productImagesRepository.save(productImages);

        if(imagemPrincipal) {
            salvarImagemPrincipalNoBD(imageObject, imageName);
        }
    }

    public ImageObject defineImageObject(Integer corId) {
        Optional<ImageObject> imageObject = imageObjectRepository.findById(corId);
        if (imageObject.isEmpty()) {
            Cor cor = corService.findById(corId);
            return createImageObject(cor);
        } else {
            return imageObject.get();
        }
    }

    public ImageObject createImageObject(Cor cor) {
        ImageObject imageObject = new ImageObject();
        imageObject.setCor(cor);
        return imageObjectRepository.save(imageObject);
    }

    public boolean listaImagensPrincipaisCompleta(ImageObject imageObject) {
        if (imageObject.getImagensPrincipais().size() < quantidadeMaximaImagensPrincipais) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean extensaoImagemPermitida(MultipartFile multipartFile) {
        String extensao = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        if(!"png".equals(extensao) && !"jpg".equals(extensao)) {
            throw new FileException("Somente arquivos PNG e JPG são permitidos");
        }
        return true;
    }

    public File convertToWebp(MultipartFile multipartFile, Integer largura, Integer altura) {
        try {
            File file = new File(".temp/imagesService/webpTemporario.webp");
            ImmutableImage image = ImmutableImage.loader().fromStream(multipartFile.getInputStream());
            WebpWriter webpWriter = new WebpWriter(); //Serve para controlar a qualidade da imagem webp de saída
            image.fit(largura, altura, Color.WHITE).output(WebpWriter.DEFAULT, ".temp/imagesService/webpTemporario.webp");

            return file;

        } catch (IOException e) {
            throw new FileException("Erro ao ler, formatar ou converter para .webp " + e.getMessage());
        }
    }

    public ImageObject rotinaParaExcluirImagem(Integer corId, String prefixo, String uri) {
        ImageObject imageObject = findById(corId);
        String imageName = imageResolver.getFileNameByURI(prefixo, uri);
        List<String> fileNames = imageResolver.getListFileNames(imageName);

        for(String fileName : fileNames) {
            deleteImage(fileName);
        }

        rotinaParaExcluirNoBD(imageObject, imageName);

        return imageObject;
    }

    @Transactional
    public void rotinaParaExcluirNoBD(ImageObject imageObject, String imageName) {

        productImagesRepository.deleteByImageName(imageName);

        removerImagemPrincipalNoBD(imageObject, imageName);
    }

    public void removerImagemPrincipalNoBD(Integer corId, String uri) {
        ImageObject imageObject = findById(corId);
        String imageName = imageResolver.getFileNameByURI("cor", uri);
        removerImagemPrincipalNoBD(imageObject, imageName);
    }

    public void removerImagemPrincipalNoBD(ImageObject imageObject, String imageName) {
        imageObject.getImagensPrincipais().remove(imageName);
        imageObjectRepository.save(imageObject);
    }

    public void salvarImagemPrincipalNoBD(Integer corId, String uri) {
        ImageObject imageObject = findById(corId);
        String imageName = imageResolver.getFileNameByURI("cor", uri);

        ProductImages productImages = productImagesRepository.findByImageName(imageName);
        if(productImages != null && productImages.getImageObject().getId() == corId) {
            salvarImagemPrincipalNoBD(imageObject, imageName);
        } else {
            throw new FileException("URI da imagem inexistente ou imagem não pertence ao produto ID " +
                    corId);
        }
    }

    public void salvarImagemPrincipalNoBD(ImageObject imageObject, String imageName) {
        if(!listaImagensPrincipaisCompleta(imageObject)) {
            imageObject.getImagensPrincipais().add(imageName);
            imageObject = imageObjectRepository.save(imageObject);
        } else {
            throw new FileException("Já existem 2 imagens principais para este recurso");
        }
    }

    public void deleteModoLavarImage(Integer modoLavarId, String uri) {
        ModoLavar modoLavar = modoLavarService.findById(modoLavarId);
        String imageName = imageResolver.getFileNameByURI("ml", uri);
        deleteImage(imageName);

        modoLavar.setImageName(null);
        modoLavarService.save(modoLavar);
    }

    public URI uploadModoLavarImage(Integer modoLavarId, MultipartFile multipartFile) {
        URI uri;
        if(extensaoImagemPermitida(multipartFile)) {
            String imageName = imageResolver.createImageName(modoLavarId, "ml");
            File file = convertToWebp(multipartFile, 150, 150);

            uri = uploadImage(file, imageName);

            ModoLavar modoLavar = modoLavarService.findById(modoLavarId);
            modoLavar.setImageName(imageName);
            modoLavar = modoLavarService.save(modoLavar);

            return uri;
        }
        return null;
    }

    public void deleteImage(String fileName) { s3Service.deleteFile(fileName);}

    public URI uploadImage(File file, String fileName) {
        return s3Service.uploadFile(file, fileName);
    }
}
