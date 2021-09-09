package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.images.ImageObject;
import br.net.luana.sistema.domain.images.ProductImages;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ImagesDTO implements Serializable{
    private static final long serialVersionUID = 1L;

        private Set<String> URIsImagensPrincipais = new HashSet<>();

        private List<String> URIImagens = new ArrayList<>();

        public ImagesDTO() {
        }

        public ImagesDTO(ImageObject entity) {
            this.URIsImagensPrincipais = entity.getURIsImagensPrincipais();
            for(ProductImages image : entity.getProductImages()) {
                this.URIImagens.add(image.getUriProductImage());
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

    public List<String> getURIImagens() {
        return URIImagens;
    }

    public void setURIImagens(List<String> URIImagens) {
        this.URIImagens = URIImagens;
    }
}

