package br.net.luana.sistema.domain.images;

import br.net.luana.sistema.domain.MasterDomain;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProductImages implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    @Value("${s3.default_uri}")
    private String defaultURI;

    @Transient
    @Value("${s3.default_format}")
    private String defaultFormat;

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

    public String getUriProductImage() {
        StringBuilder uri = new StringBuilder();
        uri.append(defaultURI).append(imageName).append(defaultFormat);
        return uri.toString();
    }
}
