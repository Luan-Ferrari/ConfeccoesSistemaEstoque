package br.net.luana.sistema.repositories.imagesRepositories;

import br.net.luana.sistema.domain.images.URIImage;
import br.net.luana.sistema.repositories.MasterRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URIImageRepository extends MasterRepository<URIImage, Integer> {

    URIImage findByURIImage(String URIImage);
}
