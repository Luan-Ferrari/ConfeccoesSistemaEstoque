package br.net.luana.sistema.domain.images;

import br.net.luana.sistema.domain.MasterDomain;
import br.net.luana.sistema.domain.cores.Cor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ImageObject implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @ElementCollection
    @CollectionTable(name = "imagens_principais")
    private Set<String> imagensPrincipais = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "cor_id")
    @MapsId
    private Cor corOfImages;

    @OneToMany(mappedBy = "imageObject")
    private List<ProductImages> productImages = new ArrayList<>();

    public ImageObject() {
    }

    public ImageObject(Integer id, Cor corOfImages) {
        this.id = id;
        this.corOfImages = corOfImages;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<String> getImagensPrincipais() {
        return imagensPrincipais;
    }

    public void setImagensPrincipais(Set<String> imagensPrincipais) {
        this.imagensPrincipais = imagensPrincipais;
    }

    public Cor getCor() {
        return corOfImages;
    }

    public void setCor(Cor corOfImages) {
        this.corOfImages = corOfImages;
    }

    public List<ProductImages> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImages> productImages) {
        this.productImages = productImages;
    }

}
