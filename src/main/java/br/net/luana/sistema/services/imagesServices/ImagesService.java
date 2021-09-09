package br.net.luana.sistema.services.imagesServices;

import br.net.luana.sistema.domain.images.ImageObject;
import org.springframework.web.multipart.MultipartFile;

public interface ImagesService {

    public ImageObject findById(Integer entityId);

    public ImageObject rotinaParaUploadDeImagem(Integer corId, MultipartFile file, Boolean imagemPrincipal);

//    public void deleteImage(Integer corId, String URIFile);
//
//    public void deleteImagemReduzida(Integer corId, String URFile);
}
