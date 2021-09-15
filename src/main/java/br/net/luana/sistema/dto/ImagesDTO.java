package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.images.ImageObject;
import br.net.luana.sistema.domain.images.ProductImages;
import br.net.luana.sistema.services.imagesServices.ImageResolver;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ImagesDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private ImageResolver imageResolver = new ImageResolver();

    private Set<String> URIsImagensPrincipais = new HashSet<>();

    private List<String> URIImagensMini = new ArrayList<>();

    private List<String> URIImagensDefault = new ArrayList<>();

    private List<String> URIImagensBig = new ArrayList<>();

    public ImagesDTO() {
    }

    public ImagesDTO(ImageObject entity) {
        this.URIsImagensPrincipais = imageResolver.getUriImagensPrincipais(entity.getImagensPrincipais());
        for(ProductImages image : entity.getProductImages()) {
            List<String> urisDaImagem = imageResolver.getUrisImagens(image.getImageName());
            this.URIImagensMini.add(urisDaImagem.get(0));
            this.URIImagensDefault.add(urisDaImagem.get(1));
            this.URIImagensBig.add(urisDaImagem.get(2));
        }
    }

    public ImagesDTO makeDTO(ImageObject entity) {
            return new ImagesDTO(entity);
        }

    public Set<String> getURIsImagensPrincipais() {
        return URIsImagensPrincipais;
    }

    public void setURIsImagensPrincipais(Set<String> URIsImagensPrincipais) {
        this.URIsImagensPrincipais = URIsImagensPrincipais;
    }

    public List<String> getURIImagensMini() {
        return URIImagensMini;
    }

    public void setURIImagensMini(List<String> URIImagensMini) {
        this.URIImagensMini = URIImagensMini;
    }

    public List<String> getURIImagensDefault() {
        return URIImagensDefault;
    }

    public void setURIImagensDefault(List<String> URIImagensDefault) {
        this.URIImagensDefault = URIImagensDefault;
    }

    public List<String> getURIImagensBig() {
        return URIImagensBig;
    }

    public void setURIImagensBig(List<String> URIImagensBig) {
        this.URIImagensBig = URIImagensBig;
    }
}

