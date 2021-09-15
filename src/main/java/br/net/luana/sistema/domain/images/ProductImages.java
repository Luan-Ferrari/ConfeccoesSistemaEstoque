package br.net.luana.sistema.domain.images;

import br.net.luana.sistema.domain.MasterDomain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProductImages implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imageName;

    @ManyToOne
    @JoinColumn(name = "image_object_id")
    private ImageObject imageObject;

    public ProductImages() {
    }

    public ProductImages(Integer id, String imageName, ImageObject imageObject) {
        this.id = id;
        this.imageName = imageName;
        this.imageObject = imageObject;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public ImageObject getImageObject() {
        return imageObject;
    }

    public void setImageObject(ImageObject imageObject) {
        this.imageObject = imageObject;
    }

}
