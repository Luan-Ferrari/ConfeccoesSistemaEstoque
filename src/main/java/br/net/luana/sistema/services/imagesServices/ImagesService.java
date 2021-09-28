package br.net.luana.sistema.services.imagesServices;

import br.net.luana.sistema.domain.images.ImageObject;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

public interface ImagesService {

    ImageObject findById(Integer entityId);

    URI uploadModoLavarImage(Integer modoLavarId, MultipartFile multipartFile);

    void deleteModoLavarImage(Integer modoLavarId, String uri);

    ImageObject rotinaParaUploadDeImagem(Integer corId, MultipartFile file, Boolean imagemPrincipal);

    ImageObject rotinaParaExcluirImagem(Integer corId, String prefixo, String uri);

    void rotinaParaExcluirNoBD(ImageObject imageObject, String imageName);

    void removerImagemPrincipalNoBD(Integer corId, String uri);

    void removerImagemPrincipalNoBD(ImageObject imageObject, String imageName);

    void salvarImagemPrincipalNoBD(Integer corId, String uri);

    void salvarImagemPrincipalNoBD(ImageObject imageObject, String imageName);
}
