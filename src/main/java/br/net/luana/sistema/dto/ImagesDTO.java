package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.images.ImageObject;
import br.net.luana.sistema.domain.images.URIImage;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImagesDTO implements Serializable{
    private static final long serialVersionUID = 1L;

        private String URIImagemReduzida;

        private List<String> URIImagens = new ArrayList<>();

        public ImagesDTO() {
        }

        public ImagesDTO(ImageObject entity) {
            this.URIImagemReduzida = entity.getURIImageReduzida();
            for(URIImage uriImage : entity.getURIImages()) {
                this.URIImagens.add(uriImage.getURIImage());
            }
        }

        public ImagesDTO makeDTO(ImageObject entity) {
            return new ImagesDTO(entity);
        }

    public String getURIImagemReduzida() {
        return URIImagemReduzida;
    }

    public void setURIImagemReduzida(String URIImagemReduzida) {
        this.URIImagemReduzida = URIImagemReduzida;
    }

    public List<String> getURIImagens() {
        return URIImagens;
    }

    public void setURIImagens(List<String> URIImagens) {
        this.URIImagens = URIImagens;
    }
}

