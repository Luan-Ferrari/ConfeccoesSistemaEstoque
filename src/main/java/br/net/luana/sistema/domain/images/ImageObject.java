package br.net.luana.sistema.domain.images;

import br.net.luana.sistema.domain.MasterDomain;
import br.net.luana.sistema.domain.cores.Cor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ImageObject implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private String URIImageReduzida;

    @OneToOne
    @JoinColumn(name = "cor_id")
    @MapsId
    private Cor corOfImages;

    @OneToMany(mappedBy = "imageObject")
    private List<URIImage> URIImages = new ArrayList<>();

    public ImageObject() {
    }

    public ImageObject(Integer id, Cor corOfImages, String URIImageReduzida) {
        this.id = id;
        this.corOfImages = corOfImages;
        this.URIImageReduzida = URIImageReduzida;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getURIImageReduzida() {
        return URIImageReduzida;
    }

    public void setURIImageReduzida(String URIImageReduzida) {
        this.URIImageReduzida = URIImageReduzida;
    }

    public Cor getCor() {
        return corOfImages;
    }

    public void setCor(Cor corOfImages) {
        this.corOfImages = corOfImages;
    }

    public List<URIImage> getURIImages() {
        return URIImages;
    }

    public void setURIImages(List<URIImage> URIImages) {
        this.URIImages = URIImages;
    }
}
