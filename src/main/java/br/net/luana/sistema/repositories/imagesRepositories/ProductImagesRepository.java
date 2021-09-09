package br.net.luana.sistema.repositories.imagesRepositories;

import br.net.luana.sistema.domain.images.ProductImages;
import br.net.luana.sistema.repositories.MasterRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImagesRepository extends MasterRepository<ProductImages, Integer> {

}
