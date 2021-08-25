package br.net.luana.sistema.domain.images;

import br.net.luana.sistema.domain.MasterDomain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class URIImage implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String URIImage;

    @ManyToOne
    @JoinColumn(name = "image_object_id")
    private ImageObject imageObject;

    public URIImage() {
    }

    public URIImage(Integer id, String URIImage, ImageObject imageObject) {
        this.id = id;
        this.URIImage = URIImage;
        this.imageObject = imageObject;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getURIImage() {
        return URIImage;
    }

    public void setURIImage(String URIImage) {
        this.URIImage = URIImage;
    }

    public ImageObject getImageObject() {
        return imageObject;
    }

    public void setImageObject(ImageObject imageObject) {
        this.imageObject = imageObject;
    }
}
